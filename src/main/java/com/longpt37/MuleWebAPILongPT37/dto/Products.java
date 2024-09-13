package com.longpt37.MuleWebAPILongPT37.dto;


import com.longpt37.MuleWebAPILongPT37.embeded.ProductId;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;


@Entity
@Data
@Table(name = "Products")
@IdClass(ProductId.class)
public class Products {
    @Id
    private String productCode;
    @Id
    private float unitPrice;
    private String productName;
    private String unit;
    private int quantityInStock;
    private Date createdDate;
    private String createdBy;

}
