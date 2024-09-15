package com.longpt37.MuleWebAPILongPT37.request;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class SODRequest {
    private String orderNo;
    private String productCode;
    private int quantity;
    private double salesPrice;
    private double tax;
}
