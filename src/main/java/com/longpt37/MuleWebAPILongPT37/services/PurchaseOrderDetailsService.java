package com.longpt37.MuleWebAPILongPT37.services;

import com.longpt37.MuleWebAPILongPT37.dto.ListResponseSOD;
import com.longpt37.MuleWebAPILongPT37.dto.PurchaseOrderDetails;
import com.longpt37.MuleWebAPILongPT37.dto.ResponseDTO;
import com.longpt37.MuleWebAPILongPT37.request.ListPODRequest;
import com.longpt37.MuleWebAPILongPT37.request.ListSODRequest;
import com.longpt37.MuleWebAPILongPT37.request.PODRequest;
import org.springframework.stereotype.Service;

@Service
public interface PurchaseOrderDetailsService {
    ResponseDTO<PurchaseOrderDetails> insertPOD(PODRequest request);
    ListResponseSOD<PurchaseOrderDetails> insertPODs(ListPODRequest request);
}
