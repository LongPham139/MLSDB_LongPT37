package com.longpt37.MuleWebAPILongPT37.embeded;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PurchaseOrdersId implements Serializable {
    private String orderNo;
    private Date orderDate;
}
