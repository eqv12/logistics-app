package com.example.service;

import com.example.entity.Address;
import com.example.entity.Customer;
import com.example.entity.Order;
import com.example.entity.ParcelDimensions;
import com.example.entity.ParcelDetails;
import com.example.entity.Vehicle; // Import Vehicle entity
import com.example.model.AddressRequest;
import com.example.model.AddressResponse;
import com.example.model.CustomerRequest;
import com.example.model.CustomerResponse;
import com.example.model.OrderRequest;
import com.example.model.OrderResponse;
// Assuming ParcelDetails and ParcelDimensions DTOs are directly from your 'com.example.model' package
// and match the structure of com.example.model.ParcelDetails and com.example.model.ParcelDimensions in your YAML
import com.example.model.OrderStatus; // From your OpenAPI spec
import com.example.model.InternalProcessingStatus; // From your OpenAPI spec
import com.example.model.UpdateOrderStatusRequest;
import com.example.model.UpdateOrderRequest;
import com.example.model.PaginatedOrderResponse;
import com.example.model.PaginationMetadata;
import com.example.repository.CustomerRepository;
import com.example.repository.OrderRepository;
// Import VehicleRepository if OrderService needs to fetch Vehicle entities directly
// import com.example.repository.VehicleRepository;


import org.locationtech.jts.geom.Point; // For JTS Point
import org.openapitools.jackson.nullable.JsonNullable; // For handling nullable DTO fields
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification; // For dynamic filtering
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException; // Standard JPA exception
import javax.persistence.criteria.Predicate; // For building specifications
import java.time.OffsetDateTime;
import java.util.ArrayList; // For list of predicates
import java.util.List;
import java.util.UUID; // For converting String ID to UUID for OrderResponse
import java.util.stream.Collectors;

@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final GeocodingService geocodingService;
    // If OrderService needs to fetch Vehicle entities (e.g., when assigning)
    // private final VehicleRepository vehicleRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository,
                        CustomerRepository customerRepository,
                        @Qualifier("googleGeocodingService") GeocodingService geocodingService
            /*, VehicleRepository vehicleRepository */) { // Add VehicleRepository if needed
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.geocodingService = geocodingService;
        // this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public OrderResponse createOrder(OrderRequest orderRequest) {
        log.info("Creating new order for customer: {}", orderRequest.getCustomerRequest().getName());

        Customer customer = mapCustomerRequestToEntity(orderRequest.getCustomerRequest());
        if (customer.getDeliveryAddress() == null) {
            throw new IllegalArgumentException("Customer delivery address is missing in the request.");
        }
        geocodeAndSetLocation(orderRequest.getCustomerRequest().getDeliveryAddress(), customer.getDeliveryAddress(), "Customer Delivery Address");

        Address sourceLocationEntity = mapAddressRequestToEntity(orderRequest.getSourceLocation());
        if (sourceLocationEntity == null) {
            throw new IllegalArgumentException("Order source location is missing in the request.");
        }
        geocodeAndSetLocation(orderRequest.getSourceLocation(), sourceLocationEntity, "Order Source Location");

        ParcelDetails parcelDetailsEntity = mapParcelDetailsRequestToEntity(orderRequest.getParcelDetails());

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(orderRequest.getOrderDate());
        order.setDeliveryType(orderRequest.getDeliveryType());
        order.setParcelDetails(parcelDetailsEntity);
        order.setSourceLocation(sourceLocationEntity);
        // assignedVehicle will be null initially

        Order savedOrder = orderRepository.save(order);
        log.info("Order created successfully with ID: {}", savedOrder.getId());

        return mapOrderEntityToResponse(savedOrder);
    }

    @Transactional(readOnly = true)
    public OrderResponse getOrderById(String orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with ID: " + orderId));
        return mapOrderEntityToResponse(order);
    }

    @Transactional(readOnly = true)
    public PaginatedOrderResponse listOrders(Pageable pageable, String status, String internalProcessingStatusFilter, String customerName, Integer deliveryType, String assignedVehicleRegistrationNumber, OffsetDateTime orderDateFrom, OffsetDateTime orderDateTo) {
        Specification<Order> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (status != null) {
                predicates.add(criteriaBuilder.equal(root.get("logisticsStatus"), status));
            }
            if (internalProcessingStatusFilter != null) {
                predicates.add(criteriaBuilder.equal(root.get("internalProcessingStatus"), internalProcessingStatusFilter));
            }
            if (customerName != null && !customerName.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("customer").get("name")), "%" + customerName.toLowerCase() + "%"));
            }
            if (deliveryType != null) {
                predicates.add(criteriaBuilder.equal(root.get("deliveryType"), deliveryType));
            }
            // Filter by assigned vehicle's registration number
            if (assignedVehicleRegistrationNumber != null && !assignedVehicleRegistrationNumber.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("assignedVehicle").get("registrationNumber"), assignedVehicleRegistrationNumber));
            }
            if (orderDateFrom != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("orderDate"), orderDateFrom));
            }
            if (orderDateTo != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("orderDate"), orderDateTo));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        Page<Order> orderPage = orderRepository.findAll(spec, pageable);

        List<OrderResponse> orderResponses = orderPage.getContent().stream()
                .map(this::mapOrderEntityToResponse)
                .collect(Collectors.toList());

        PaginationMetadata metadata = new PaginationMetadata();
        metadata.setTotalItems((int) orderPage.getTotalElements());
        metadata.setLimit(orderPage.getSize());
        if (orderPage.getPageable().isPaged()) {
            metadata.setOffset((int) orderPage.getPageable().getOffset());
        } else {
            metadata.setOffset(0);
        }

        PaginatedOrderResponse response = new PaginatedOrderResponse();
        response.setData(orderResponses);
        response.setMetadata(metadata);

        return response;
    }

    @Transactional
    public OrderResponse updateOrderStatus(String orderId, UpdateOrderStatusRequest statusRequest) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with ID: " + orderId));

        log.info("Updating logistics status for order ID: {} from {} to {}",
                orderId, order.getLogisticsStatus(), statusRequest.getStatus().getValue());
        order.setLogisticsStatus(statusRequest.getStatus().getValue());
        Order updatedOrder = orderRepository.save(order);
        return mapOrderEntityToResponse(updatedOrder);
    }

    @Transactional
    public OrderResponse updateOrderDetails(String orderId, UpdateOrderRequest updateOrderRequest) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with ID: " + orderId));

        log.info("Attempting to PATCH update order details for ID: {}", orderId);
        boolean updated = false;

        if (updateOrderRequest.getDeliveryAddress() != null) {
            if (order.getCustomer() == null) {
                throw new IllegalStateException("Order " + orderId + " does not have an associated customer to update address for.");
            }
            AddressRequest newAddrReq = updateOrderRequest.getDeliveryAddress();
            Address newDeliveryAddressEntity = mapAddressRequestToEntity(newAddrReq);
            geocodeAndSetLocation(newAddrReq, newDeliveryAddressEntity, "Updated Customer Delivery Address");
            order.getCustomer().setDeliveryAddress(newDeliveryAddressEntity);
            updated = true;
            log.info("Updated delivery address for order ID: {}", orderId);
        }
        // TODO: Add logic for other patchable fields from UpdateOrderRequest

        if (updated) {
            Order savedOrder = orderRepository.save(order);
            return mapOrderEntityToResponse(savedOrder);
        } else {
            log.info("No fields were updated for order ID: {}", orderId);
            return mapOrderEntityToResponse(order);
        }
    }

    @Transactional
    public void deletePendingOrder(String orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with ID: " + orderId));

        if (!OrderStatus.PENDING.getValue().equalsIgnoreCase(order.getLogisticsStatus())) {
            throw new IllegalStateException("Order " + orderId + " cannot be deleted as its status is not 'Pending'. Current status: " + order.getLogisticsStatus());
        }
        log.info("Deleting order ID: {}", orderId);
        orderRepository.delete(order);
    }

    @Transactional(readOnly = true)
    public PaginatedOrderResponse getUnassignedOrders(Pageable pageable, Integer deliveryTypeFilter) {
        String determinedReadyStatusValue;
        try {
            determinedReadyStatusValue = InternalProcessingStatus.READY_FOR_DISPATCH.getValue();
        } catch (IllegalArgumentException e) {
            log.warn("Could not resolve InternalProcessingStatus.READY_FOR_DISPATCH. Trying 'ReadyForDispatch'. Check generated enum names.", e);
            try {
                determinedReadyStatusValue = InternalProcessingStatus.valueOf("ReadyForDispatch").getValue();
            } catch (IllegalArgumentException e2) {
                log.error("Could not resolve InternalProcessingStatus with 'ReadyForDispatch' either. Defaulting to string 'ReadyForDispatch'. Critical: Verify generated enum.", e2);
                determinedReadyStatusValue = "ReadyForDispatch";
            }
        }

        final String readyStatusValueForLambda = determinedReadyStatusValue;

        Specification<Order> internalStatusSpec = (root, query, cb) ->
                cb.equal(root.get("internalProcessingStatus"), readyStatusValueForLambda);

        Specification<Order> notAssignedSpec = (root, query, cb) ->
                cb.isNull(root.get("assignedVehicle")); // Check the Vehicle object itself

        Specification<Order> spec = Specification.where(internalStatusSpec).and(notAssignedSpec);

        if (deliveryTypeFilter != null) {
            Specification<Order> deliveryTypeSpec = (root, query, cb) ->
                    cb.equal(root.get("deliveryType"), deliveryTypeFilter);
            spec = spec.and(deliveryTypeSpec);
        }
        Page<Order> orderPage = orderRepository.findAll(spec, pageable);

        List<OrderResponse> orderResponses = orderPage.getContent().stream()
                .map(this::mapOrderEntityToResponse)
                .collect(Collectors.toList());

        PaginationMetadata metadata = new PaginationMetadata();
        metadata.setTotalItems((int) orderPage.getTotalElements());
        metadata.setLimit(orderPage.getSize());
        if (orderPage.getPageable().isPaged()) {
            metadata.setOffset((int) orderPage.getPageable().getOffset());
        } else {
            metadata.setOffset(0);
        }

        PaginatedOrderResponse response = new PaginatedOrderResponse();
        response.setData(orderResponses);
        response.setMetadata(metadata);
        return response;
    }

    private void geocodeAndSetLocation(AddressRequest addressRequest, Address addressEntity, String addressTypeDescription) {
        if (addressRequest == null || addressEntity == null) {
            log.warn("{} AddressRequest or AddressEntity is null, skipping geocoding.", addressTypeDescription);
            return;
        }
        try {
            GeocodingService.Coordinates coords = geocodingService.geocode(addressRequest);
            if (coords != null) {
                addressEntity.setLocationFromDoubles(coords.latitude, coords.longitude);
                log.info("Successfully geocoded {} for: [Street: {}, City: {}] -> Lat: {}, Lon: {}",
                        addressTypeDescription, addressRequest.getStreet(), addressRequest.getCity(), coords.latitude, coords.longitude);
            } else {
                log.warn("Geocoding returned null for {}: [Street: {}, City: {}]. Location will not be set.",
                        addressTypeDescription, addressRequest.getStreet(), addressRequest.getCity());
            }
        } catch (Exception e) {
            log.error("Exception during geocoding for {}: [Street: {}, City: {}]. Error: {}",
                    addressTypeDescription, addressRequest.getStreet(), addressRequest.getCity(), e.getMessage(), e);
        }
    }

    private Customer mapCustomerRequestToEntity(CustomerRequest customerRequest) {
        if (customerRequest == null) return null;
        Customer customerEntity = new Customer();
        customerEntity.setName(customerRequest.getName());
        customerEntity.setPhoneNumber(customerRequest.getPhoneNumber());
        if (customerRequest.getDeliveryAddress() != null) {
            customerEntity.setDeliveryAddress(mapAddressRequestToEntity(customerRequest.getDeliveryAddress()));
        }
        return customerEntity;
    }

    private Address mapAddressRequestToEntity(AddressRequest addressRequest) {
        if (addressRequest == null) return null;
        Address addressEntity = new Address();
        addressEntity.setStreet(addressRequest.getStreet());
        addressEntity.setCity(addressRequest.getCity());
        addressEntity.setState(addressRequest.getState());
        addressEntity.setPinCode(addressRequest.getPinCode());
        return addressEntity;
    }

    private ParcelDetails mapParcelDetailsRequestToEntity(com.example.model.ParcelDetails parcelDetailsRequest) {
        if (parcelDetailsRequest == null) return null;
        ParcelDetails detailsEntity = new ParcelDetails();
        detailsEntity.setWeight(parcelDetailsRequest.getWeight());
        if (parcelDetailsRequest.getDimensions() != null) {
            ParcelDimensions dimensionsEntity = new ParcelDimensions();
            dimensionsEntity.setLength(parcelDetailsRequest.getDimensions().getLength());
            dimensionsEntity.setWidth(parcelDetailsRequest.getDimensions().getWidth());
            dimensionsEntity.setHeight(parcelDetailsRequest.getDimensions().getHeight());
            detailsEntity.setDimensions(dimensionsEntity);
        }
        return detailsEntity;
    }

    public OrderResponse mapOrderEntityToResponse(Order order) {
        if (order == null) return null;
        OrderResponse response = new OrderResponse();

        if (order.getId() != null) {
            try {
                response.setId(UUID.fromString(order.getId()));
            } catch (IllegalArgumentException e) {
                log.error("Could not parse order ID string to UUID: {}", order.getId(), e);
            }
        }

        response.setCustomerResponse(mapCustomerEntityToResponse(order.getCustomer()));
        response.setOrderDate(order.getOrderDate());
        response.setDeliveryType(order.getDeliveryType());
        response.setParcelDetails(mapParcelDetailsEntityToResponse(order.getParcelDetails()));
        response.setSourceLocation(mapAddressEntityToResponse(order.getSourceLocation()));

        if (order.getLogisticsStatus() != null) {
            response.setStatus(OrderStatus.fromValue(order.getLogisticsStatus()));
        }
        if (order.getInternalProcessingStatus() != null) {
            response.setInternalProcessingStatus(InternalProcessingStatus.fromValue(order.getInternalProcessingStatus()));
        }

        response.setDeliveryDate(JsonNullable.of(order.getDeliveryDate()));

        // Corrected: Get registration number from the Vehicle object
        if (order.getAssignedVehicle() != null) {
            response.setAssignedVehicleId(JsonNullable.of(order.getAssignedVehicle().getRegistrationNumber()));
        } else {
            // If you want to explicitly set it to null when not present, otherwise JsonNullable.undefined() is also an option
            response.setAssignedVehicleId(JsonNullable.of(null));
        }
        return response;
    }

    private CustomerResponse mapCustomerEntityToResponse(Customer customer) {
        if (customer == null) return null;
        CustomerResponse response = new CustomerResponse();
        if (customer.getId() != null) {
            try {
                response.setId(UUID.fromString(customer.getId()));
            } catch (IllegalArgumentException e) {
                log.error("Could not parse customer ID string to UUID: {}", customer.getId(), e);
            }
        }
        response.setName(customer.getName());
        response.setPhoneNumber(customer.getPhoneNumber());
        response.setAddress(mapAddressEntityToResponse(customer.getDeliveryAddress()));
        return response;
    }

    private AddressResponse mapAddressEntityToResponse(Address addressEntity) {
        if (addressEntity == null) return null;
        AddressResponse response = new AddressResponse();
        response.setStreet(addressEntity.getStreet());
        response.setCity(addressEntity.getCity());
        response.setState(addressEntity.getState());
        response.setPinCode(addressEntity.getPinCode());
        response.setLatitude(addressEntity.getLatitude());
        response.setLongitude(addressEntity.getLongitude());
        return response;
    }

    private com.example.model.ParcelDetails mapParcelDetailsEntityToResponse(ParcelDetails parcelDetailsEntity) {
        if (parcelDetailsEntity == null) return null;
        com.example.model.ParcelDetails response = new com.example.model.ParcelDetails();
        response.setWeight(parcelDetailsEntity.getWeight());
        if (parcelDetailsEntity.getDimensions() != null) {
            com.example.model.ParcelDimensions dimensionsResponse = new com.example.model.ParcelDimensions();
            dimensionsResponse.setLength(parcelDetailsEntity.getDimensions().getLength());
            dimensionsResponse.setWidth(parcelDetailsEntity.getDimensions().getWidth());
            dimensionsResponse.setHeight(parcelDetailsEntity.getDimensions().getHeight());
            response.setDimensions(dimensionsResponse);
        }
        response.setVolume(parcelDetailsEntity.getVolumeM3());
        return response;
    }
}
