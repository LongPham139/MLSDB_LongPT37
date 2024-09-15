package com.longpt37.MuleWebAPILongPT37.dto;


import com.longpt37.MuleWebAPILongPT37.embeded.ProductId;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "Products")
@IdClass(ProductId.class)
public class Products {
    @Id
    private String productCode;
    @Id
    private double unitPrice;
    private String productName;
    private String unit;
    private double quantityInStock;
    private Date createdDate;
    private String createdBy;

}
