package com.example.controller; // Assuming your controllers are in this package

import com.example.model.OrderRequest;
import com.example.model.OrderResponse;
import com.example.model.UpdateOrderRequest;
import com.example.model.UpdateOrderStatusRequest;
import com.example.model.PaginatedOrderResponse;
import com.example.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid; // For @Valid on request bodies
import javax.validation.constraints.Min; // For parameter validation
import java.time.OffsetDateTime;
// Assuming your OrdersApi interface is in this package, if generated.
// If not, this controller directly implements the endpoint mappings.
// import com.example.api.OrdersApi; // Or whatever your generated API interface is named

@RestController
@RequestMapping("/api/v1/orders") // Base path for all order-related endpoints
@Validated // Enables validation of request parameters annotated with constraints
public class OrdersController implements OrdersApi{ // If you have a generated OrdersApi, implement it: implements OrdersApi

    private final OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    // POST /api/v1/orders
    // Corresponds to operationId: createOrder
    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderRequest orderRequest) {
        OrderResponse createdOrder = orderService.createOrder(orderRequest);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    // GET /api/v1/orders/{id}
    // Corresponds to operationId: getOrderById
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable("id") String id) {
        OrderResponse order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    // GET /api/v1/orders
    // Corresponds to operationId: listOrders
    @GetMapping
    public ResponseEntity<PaginatedOrderResponse> listOrders(
            @RequestParam(value = "limit", defaultValue = "20") @Min(1) int limit,
            @RequestParam(value = "offset", defaultValue = "0") @Min(0) int offset,
            @RequestParam(value = "sortBy", defaultValue = "orderDate") String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = "desc") String sortDirection,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "internalProcessingStatus", required = false) String internalProcessingStatus,
            @RequestParam(value = "customerName", required = false) String customerName,
            @RequestParam(value = "deliveryType", required = false) Integer deliveryType,
            @RequestParam(value = "assignedVehicleId", required = false) String assignedVehicleId,
            @RequestParam(value = "orderDateFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime orderDateFrom,
            @RequestParam(value = "orderDateTo", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime orderDateTo) {

        Sort.Direction direction = "asc".equalsIgnoreCase(sortDirection) ? Sort.Direction.ASC : Sort.Direction.DESC;
        // Ensure offset is correctly calculated for page number if page is 0-indexed
        int pageNumber = offset / limit;
        Pageable pageable = PageRequest.of(pageNumber, limit, Sort.by(direction, sortBy));

        PaginatedOrderResponse orders = orderService.listOrders(
                pageable, status, internalProcessingStatus, customerName,
                deliveryType, assignedVehicleId, orderDateFrom, orderDateTo
        );
        return ResponseEntity.ok(orders);
    }

    // PUT /api/v1/orders/{id}/status
    // Corresponds to operationId: updateOrderStatus
    @PutMapping("/{id}/status")
    public ResponseEntity<OrderResponse> updateOrderStatus(
            @PathVariable("id") String id,
            @Valid @RequestBody UpdateOrderStatusRequest updateOrderStatusRequest) {
        OrderResponse updatedOrder = orderService.updateOrderStatus(id, updateOrderStatusRequest);
        return ResponseEntity.ok(updatedOrder);
    }

    // PATCH /api/v1/orders/{id}
    // Corresponds to operationId: updateOrderDetails
    @PatchMapping("/{id}")
    public ResponseEntity<OrderResponse> updateOrderDetails(
            @PathVariable("id") String id,
            @Valid @RequestBody UpdateOrderRequest updateOrderRequest) {
        OrderResponse updatedOrder = orderService.updateOrderDetails(id, updateOrderRequest);
        return ResponseEntity.ok(updatedOrder);
    }

    // DELETE /api/v1/orders/{id}
    // Corresponds to operationId: deletePendingOrder
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePendingOrder(@PathVariable("id") String id) {
        orderService.deletePendingOrder(id);
        return ResponseEntity.noContent().build();
    }

    // GET /api/v1/orders/unassigned
    // Corresponds to operationId: getUnassignedOrders
    @GetMapping("/unassigned")
    public ResponseEntity<PaginatedOrderResponse> getUnassignedOrders(
            @RequestParam(value = "limit", defaultValue = "20") @Min(1) int limit,
            @RequestParam(value = "offset", defaultValue = "0") @Min(0) int offset,
            @RequestParam(value = "sortBy", defaultValue = "deliveryType") String sortBy, // Default sort by deliveryType
            @RequestParam(value = "sortDirection", defaultValue = "asc") String sortDirection, // Ascending for deliveryType
            @RequestParam(value = "deliveryType", required = false) Integer deliveryTypeFilter) {

        Sort.Direction direction = "asc".equalsIgnoreCase(sortDirection) ? Sort.Direction.ASC : Sort.Direction.DESC;
        int pageNumber = offset / limit;
        Pageable pageable = PageRequest.of(pageNumber, limit, Sort.by(direction, sortBy));

        PaginatedOrderResponse orders = orderService.getUnassignedOrders(pageable, deliveryTypeFilter);
        return ResponseEntity.ok(orders);
    }
}
