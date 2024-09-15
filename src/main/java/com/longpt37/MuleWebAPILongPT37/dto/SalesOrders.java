package com.longpt37.MuleWebAPILongPT37.dto;

import com.longpt37.MuleWebAPILongPT37.embeded.SalesOrdersId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@Table(name = "SalesOrders")
@IdClass(SalesOrdersId.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalesOrders {
    @Id
    private String orderNo;
    @Id
    private Date orderDate;
    private String title;
    private String description;
    private Date createdDate;
    private String createdBy;
}
