package com.longpt37.MuleWebAPILongPT37.servicesImplement;

import com.longpt37.MuleWebAPILongPT37.dto.ResponseDTO;
import com.longpt37.MuleWebAPILongPT37.dto.SalesOrders;
import com.longpt37.MuleWebAPILongPT37.repository.SalesOrderRepository;
import com.longpt37.MuleWebAPILongPT37.request.SORequest;
import com.longpt37.MuleWebAPILongPT37.services.SalesOrdersService;
import com.longpt37.MuleWebAPILongPT37.utils.ConvertStringToDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
@RequiredArgsConstructor
public class SalesOrdersServiceImplement implements SalesOrdersService {
    private final SalesOrderRepository salesOrderRepository;
    private final ConvertStringToDate util = new ConvertStringToDate();

    @Override
    public ResponseDTO<SalesOrders> insertSO(SORequest request) throws ParseException {
        ResponseDTO responseDTO = new ResponseDTO();
        SalesOrders so = salesOrderRepository.findByOrderNoAndOrderDate(request.getOrderNo(), util.convertDate(request.getOrderDate()));
        if(so != null) {
            responseDTO.setStatus("500");
            responseDTO.setData(so);
            responseDTO.setMessage("Data existed!!!");
            return responseDTO;
        }
        so = SalesOrders.builder()
                .orderNo(request.getOrderNo())
                .orderDate(util.convertDate(request.getOrderDate()))
                .createdBy("LongPT37")
                .title(request.getTitle())
                .createdDate(util.convertDate(request.getCreatedDate()))
                .description(request.getDescription())
                .build();
        salesOrderRepository.save(so);
        responseDTO.setStatus("200");
        responseDTO.setData(so);
        responseDTO.setMessage("Insert Success!!!");
        return responseDTO;
    }
}
