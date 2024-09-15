package com.longpt37.MuleWebAPILongPT37.request;

import lombok.Data;

@Data
public class ProductRequest {
    private String productCode;
    private double unitPrice;
    private String productName;
    private String unit;
    private double quantityInStock;
    private String createdDate;
    private String createdBy;
}
