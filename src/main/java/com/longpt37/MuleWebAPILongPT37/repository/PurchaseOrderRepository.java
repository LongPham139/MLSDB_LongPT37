package com.longpt37.MuleWebAPILongPT37.repository;

import com.longpt37.MuleWebAPILongPT37.dto.PurchaseOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrders, String> {
    @Query(nativeQuery = true, value = "SELECT * FROM PurchaseOrders WHERE OrderNo = :orderNo AND OrderDate = :orderDate")
    PurchaseOrders findByOrderNoAndOrderDate(String orderNo, Date orderDate);
}
