package com.longpt37.MuleWebAPILongPT37.dto;

import com.longpt37.MuleWebAPILongPT37.embeded.SalesOrderDetailsId;
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
@Table(name = "SalesOrderDetails")
@IdClass(SalesOrderDetailsId.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrderDetails {
    @Id
    private String orderNo;
    @Id
    private String productCode;
    private int quantity;
    @Id
    private double salesPrice;
    private double tax;
}
