package com.longpt37.MuleWebAPILongPT37.request;

import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
@Data
public class PORequest {
    private String orderNo;
    private String orderDate;
    private String title;
    private String description;
    private String createdDate;
    private String createdBy;
}
