package com.longpt37.MuleWebAPILongPT37.repository;

import com.longpt37.MuleWebAPILongPT37.dto.SalesOrders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface SalesOrderRepository extends JpaRepository<SalesOrders, String> {
    SalesOrders findByOrderNoAndOrderDate(String orderNo, Date orderDate);
}
