package com.longpt37.MuleWebAPILongPT37.services;

import com.longpt37.MuleWebAPILongPT37.dto.ResponseDTO;
import com.longpt37.MuleWebAPILongPT37.dto.SalesOrderDetails;
import com.longpt37.MuleWebAPILongPT37.request.SODRequest;
import org.springframework.stereotype.Service;

@Service
public interface SalesOrderDetailsService {
    ResponseDTO<SalesOrderDetails> insertSOD(SODRequest request);
}
