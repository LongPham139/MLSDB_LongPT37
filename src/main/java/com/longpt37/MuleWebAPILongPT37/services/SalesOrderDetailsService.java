package com.longpt37.MuleWebAPILongPT37.services;

import com.longpt37.MuleWebAPILongPT37.dto.ListResponseDTO;
import com.longpt37.MuleWebAPILongPT37.dto.ListResponseSOD;
import com.longpt37.MuleWebAPILongPT37.dto.ResponseDTO;
import com.longpt37.MuleWebAPILongPT37.dto.SalesOrderDetails;
import com.longpt37.MuleWebAPILongPT37.request.ListSODRequest;
import com.longpt37.MuleWebAPILongPT37.request.SODRequest;
import org.springframework.stereotype.Service;

@Service
public interface SalesOrderDetailsService {
    ResponseDTO<SalesOrderDetails> insertSOD(SODRequest request);
    ListResponseSOD<SalesOrderDetails> insertSODs(ListSODRequest requests);
}
