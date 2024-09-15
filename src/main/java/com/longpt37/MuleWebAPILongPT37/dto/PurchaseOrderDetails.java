package com.longpt37.MuleWebAPILongPT37.dto;

import com.longpt37.MuleWebAPILongPT37.embeded.ProductId;
import com.longpt37.MuleWebAPILongPT37.embeded.PurchaseOrderDetailsId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "PurchaseOrderDetails")
@IdClass(PurchaseOrderDetailsId.class)
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
