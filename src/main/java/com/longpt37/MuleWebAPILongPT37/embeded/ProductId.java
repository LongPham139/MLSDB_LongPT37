package com.longpt37.MuleWebAPILongPT37.embeded;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductId implements Serializable {
    private String productCode;
    private float unitPrice;


}
