package com.longpt37.MuleWebAPILongPT37.repository;

import com.longpt37.MuleWebAPILongPT37.dto.SalesOrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderDetailRepository extends JpaRepository<SalesOrderDetails, String> {
    SalesOrderDetails findByOrderNo(String orderNo);
}
