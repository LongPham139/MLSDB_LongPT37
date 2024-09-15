package com.longpt37.MuleWebAPILongPT37.dto;

import lombok.Data;

import java.util.List;

@Data
public class ListResponseSOD<T> {
    private String message;
    private List<T> dataSuccess;
    private List<T> dataFail;
    private String status;
}
