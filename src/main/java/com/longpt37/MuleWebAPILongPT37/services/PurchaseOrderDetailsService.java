package com.longpt37.MuleWebAPILongPT37.services;

import com.longpt37.MuleWebAPILongPT37.dto.PurchaseOrderDetails;
import com.longpt37.MuleWebAPILongPT37.dto.ResponseDTO;
import com.longpt37.MuleWebAPILongPT37.request.PODRequest;
import org.springframework.stereotype.Service;

@Service
public interface PurchaseOrderDetailsService {
    ResponseDTO<PurchaseOrderDetails> insertPOD(PODRequest request);
}
