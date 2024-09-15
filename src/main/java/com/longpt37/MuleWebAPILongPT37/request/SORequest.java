package com.longpt37.MuleWebAPILongPT37.request;

import jakarta.persistence.Id;
import lombok.Data;
@Data
public class SORequest {
    private String orderNo;
    private String orderDate;
    private String title;
    private String description;
    private String createdDate;
    private String createdBy;
}
