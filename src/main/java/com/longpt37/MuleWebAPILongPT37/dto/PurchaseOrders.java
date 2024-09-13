package com.longpt37.MuleWebAPILongPT37.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "PurchaseOrders")
public class PurchaseOrders {
    @Id
    private String orderNo;
    @Id
    private Date orderDate;
    private String title;
    private String description;
    private Date createdDate;
    private String createdBy;

}
