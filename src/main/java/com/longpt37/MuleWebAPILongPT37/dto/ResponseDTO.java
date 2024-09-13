package com.longpt37.MuleWebAPILongPT37.dto;

import lombok.Data;

@Data
public class ResponseDTO<T> {
    private String message;
    private T data;
    private String status;
}
