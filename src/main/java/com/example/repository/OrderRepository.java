package com.example.repository;

import com.example.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor; // For dynamic queries
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * JPA Repository for Order entities.
 * Extends JpaSpecificationExecutor to allow for dynamic query building
 * for filtering and searching orders.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, String>, JpaSpecificationExecutor<Order> { // String is the type of Order's @Id

    // Example custom query methods (you can add more based on your filtering needs):

    /**
     * Finds orders by their logistics status, with pagination.
     * @param logisticsStatus The logistics status to filter by.
     * @param pageable Pagination information.
     * @return A page of orders matching the status.
     */
    Page<Order> findByLogisticsStatus(String logisticsStatus, Pageable pageable);

    /**
     * Finds orders by their internal processing status, with pagination.
     * @param internalProcessingStatus The internal processing status to filter by.
     * @param pageable Pagination information.
     * @return A page of orders matching the status.
     */
    Page<Order> findByInternalProcessingStatus(String internalProcessingStatus, Pageable pageable);

    /**
     * Finds orders for a specific customer by customer ID, with pagination.
     * This queries through the customer association.
     * @param customerId The ID of the customer.
     * @param pageable Pagination information.
     * @return A page of orders for the given customer.
     */
    Page<Order> findByCustomer_Id(String customerId, Pageable pageable); // Querying by embedded Customer's ID


    /**
     * Finds orders by the registration number of the assigned vehicle, with pagination.
     * Corrected method name to reflect the actual property path: Order.assignedVehicle.registrationNumber
     * @param registrationNumber The registration number of the assigned vehicle.
     * @param pageable Pagination information.
     * @return A page of orders assigned to the vehicle.
     */
    Page<Order> findByAssignedVehicle_RegistrationNumber(String registrationNumber, Pageable pageable);


    /**
     * Finds orders within a specific date range, with pagination.
     * @param startDate The start of the date range (inclusive).
     * @param endDate The end of the date range (inclusive).
     * @param pageable Pagination information.
     * @return A page of orders within the date range.
     */
    Page<Order> findByOrderDateBetween(OffsetDateTime startDate, OffsetDateTime endDate, Pageable pageable);


    /**
     * Finds orders that are ready for dispatch (based on internalProcessingStatus)
     * and are not yet assigned to any vehicle (assignedVehicle is null).
     * This is for the /api/v1/orders/unassigned endpoint.
     * @param internalProcessingStatus The status indicating readiness (e.g., "ReadyForDispatch").
     * @param pageable Pagination information.
     * @return A page of unassigned, ready orders.
     */
    Page<Order> findByInternalProcessingStatusAndAssignedVehicleIsNull(String internalProcessingStatus, Pageable pageable);

    // Note: The previous duplicate findByAssignedVehicleId method has been effectively corrected by the change above.
    // If there was a distinct purpose for a second method querying by vehicle,
    // it would need a different name or different parameters.
    // The method findByAssignedVehicle_RegistrationNumber now correctly serves the purpose of finding orders
    // assigned to a specific vehicle via its registration number.


    // For the reporting endpoint (/api/v1/report) to count orders by status.
    // You might create more specific count queries or use a different approach
    // if the report needs to be more complex (e.g., grouping by date ranges too).

    @Query("SELECT o.logisticsStatus, COUNT(o) FROM Order o GROUP BY o.logisticsStatus")
    List<Object[]> countOrdersByLogisticsStatus(); // Returns List of [status, count]

    // For the /api/v1/shipping-overview endpoint
    // This query finds orders that were either delivered on a specific day
    // OR were set to 'Out for Delivery' on that day (or are still 'Out for Delivery' from that day).
    // This is a simplified example; precise logic might depend on how status updates are timestamped.
    // For a more accurate "Out for Delivery on this day", you'd need to track status change timestamps.
    // This example focuses on orders *currently* Out for Delivery or *delivered on* the targetDate.
    @Query("SELECT o FROM Order o WHERE (o.logisticsStatus = 'Delivered' AND FUNCTION('DATE', o.deliveryDate) = FUNCTION('DATE', :targetDate)) OR (o.logisticsStatus = 'Out for Delivery' AND FUNCTION('DATE', o.updatedAt) <= FUNCTION('DATE', :targetDate))")
    Page<Order> findShippingOverviewByDate(@Param("targetDate") OffsetDateTime targetDate, Pageable pageable);

}