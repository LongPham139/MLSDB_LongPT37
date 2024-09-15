package com.longpt37.MuleWebAPILongPT37.repository;

import com.longpt37.MuleWebAPILongPT37.dto.PurchaseOrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderDetailsRepository extends JpaRepository<PurchaseOrderDetails, String> {
    PurchaseOrderDetails findByOrderNo(String orderNo);

    PurchaseOrderDetails findByOrderNoAndProductCodeAndPurchasePrice(String orderNo, String productCode, double purchasePrice);
}
