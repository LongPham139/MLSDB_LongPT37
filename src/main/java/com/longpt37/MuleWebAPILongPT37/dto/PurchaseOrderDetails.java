package com.longpt37.MuleWebAPILongPT37.dto;

import com.longpt37.MuleWebAPILongPT37.embeded.ProductId;
import com.longpt37.MuleWebAPILongPT37.embeded.PurchaseOrderDetailsId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "PurchaseOrderDetails")
@IdClass(PurchaseOrderDetailsId.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderDetails {
    @Id
    private String orderNo;
    @Id
    private String productCode;
    private int quantity;
    @Id
    private double purchasePrice;
    private double tax;

}
