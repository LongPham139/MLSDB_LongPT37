package com.longpt37.MuleWebAPILongPT37.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "PurchaseOrderDetails")
public class PurchaseOrderDetails {
    @Id
    private String orderNo;
    @Id
    private String productCode;
    private int quantity;
    @Id
    private float purchasePrice;
    private float tax;

}
