package com.longpt37.MuleWebAPILongPT37.services;

import com.longpt37.MuleWebAPILongPT37.dto.ResponseDTO;
import com.longpt37.MuleWebAPILongPT37.dto.SalesOrders;
import com.longpt37.MuleWebAPILongPT37.request.SORequest;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public interface SalesOrdersService {
    ResponseDTO<SalesOrders> insertSO(SORequest request) throws ParseException;
}
