package com.longpt37.MuleWebAPILongPT37.dto;

import lombok.Data;

import java.util.List;

@Data
public class ListResponseDTO<T> {
    private String message;
    private List<T> data;
    private String status;
}
