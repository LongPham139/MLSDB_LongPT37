package com.longpt37.MuleWebAPILongPT37.services;

import com.longpt37.MuleWebAPILongPT37.dto.ResponseDTO;
import com.longpt37.MuleWebAPILongPT37.dto.SalesOrders;
import com.longpt37.MuleWebAPILongPT37.request.SORequest;
import org.springframework.stereotype.Service;

@Service
public interface SalesOrdersService {
    ResponseDTO<SalesOrders> insertSO(SORequest request);
}
