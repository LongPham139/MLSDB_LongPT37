package com.longpt37.MuleWebAPILongPT37.services;

import com.longpt37.MuleWebAPILongPT37.dto.PurchaseOrders;
import com.longpt37.MuleWebAPILongPT37.dto.ResponseDTO;
import com.longpt37.MuleWebAPILongPT37.request.PORequest;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public interface PurchaseOrdersService {
    ResponseDTO<PurchaseOrders> insertPO(PORequest request) throws ParseException;
}
