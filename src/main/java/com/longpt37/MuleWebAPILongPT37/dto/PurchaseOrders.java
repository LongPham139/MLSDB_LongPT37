package com.longpt37.MuleWebAPILongPT37.dto;

import com.longpt37.MuleWebAPILongPT37.embeded.PurchaseOrdersId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "PurchaseOrders")
@IdClass(PurchaseOrdersId.class)
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
