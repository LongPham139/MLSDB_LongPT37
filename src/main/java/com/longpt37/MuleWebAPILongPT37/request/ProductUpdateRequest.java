package com.longpt37.MuleWebAPILongPT37.request;

import lombok.Data;

@Data
public class ProductUpdateRequest {
    private String productCode;
    private String orderNo;
    private double quantityInStock;
}
