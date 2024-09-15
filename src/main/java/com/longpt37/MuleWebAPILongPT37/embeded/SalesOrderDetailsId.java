package com.longpt37.MuleWebAPILongPT37.embeded;

import lombok.Data;

import java.io.Serializable;

@Data
public class SalesOrderDetailsId implements Serializable {
    private String orderNo;
    private String productCode;
    private double salesPrice;
}
