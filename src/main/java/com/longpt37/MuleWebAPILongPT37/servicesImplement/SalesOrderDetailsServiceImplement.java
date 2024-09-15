package com.longpt37.MuleWebAPILongPT37.servicesImplement;

import com.longpt37.MuleWebAPILongPT37.dto.*;
import com.longpt37.MuleWebAPILongPT37.repository.SalesOrderDetailRepository;
import com.longpt37.MuleWebAPILongPT37.request.ListSODRequest;
import com.longpt37.MuleWebAPILongPT37.request.SODRequest;
import com.longpt37.MuleWebAPILongPT37.services.SalesOrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesOrderDetailsServiceImplement implements SalesOrderDetailsService {
    private final SalesOrderDetailRepository salesOrderDetailRepository;

    @Override
    public ResponseDTO<SalesOrderDetails> insertSOD(SODRequest request) {
        ResponseDTO responseDTO = new ResponseDTO();
        SalesOrderDetails sod = salesOrderDetailRepository.findByOrderNoAndProductCodeAndSalesPrice(request.getOrderNo(), request.getProductCode(), request.getSalesPrice());
        if (sod != null) {
            responseDTO.setStatus("500");
            responseDTO.setData(sod);
            responseDTO.setMessage("Data existed!!!");
            return responseDTO;
        }
        sod = SalesOrderDetails.builder()
                .orderNo(request.getOrderNo())
                .productCode(request.getProductCode())
                .salesPrice(request.getSalesPrice())
                .quantity(request.getQuantity())
                .tax(request.getTax())
                .build();
        salesOrderDetailRepository.save(sod);
        responseDTO.setStatus("200");
        responseDTO.setData(sod);
        responseDTO.setMessage("Insert Success!!!");
        return responseDTO;
    }

    @Override
    public ListResponseSOD<SalesOrderDetails> insertSODs(ListSODRequest requests) {
        ListResponseSOD<SalesOrderDetails> responseDTO = new ListResponseSOD<>();
        List<SODRequest> list = requests.getListSOD();
        List<SalesOrderDetails> listSuccess = new ArrayList<>();
        List<SalesOrderDetails> listFail = new ArrayList<>();
        if (requests == null) {
            responseDTO.setStatus("500");
            responseDTO.setMessage("List is empty!!!");
            return responseDTO;
        }
        for (int i = 0; i < list.size(); i++) {
            SalesOrderDetails sod = salesOrderDetailRepository.findByOrderNoAndProductCodeAndSalesPrice(list.get(i).getOrderNo(), list.get(i).getProductCode(), list.get(i).getSalesPrice());
            if (sod != null) {
                listFail.add(sod);
            } else {
                sod = SalesOrderDetails.builder()
                        .orderNo(list.get(i).getOrderNo())
                        .productCode(list.get(i).getProductCode())
                        .salesPrice(list.get(i).getSalesPrice())
                        .quantity(list.get(i).getQuantity())
                        .tax(list.get(i).getTax())
                        .build();
                salesOrderDetailRepository.save(sod);
                listSuccess.add(sod);
            }
        }
        responseDTO.setStatus("200");
        if (listFail.size() == list.size()) {
            responseDTO.setDataFail(listFail);
            responseDTO.setMessage("Insert Fail!!!");
        } else if (listSuccess.size() == list.size()){
            responseDTO.setDataSuccess(listSuccess);
            responseDTO.setMessage("Insert Success!!!");
        }else if (listSuccess.size() > 0 && listFail.size() > 0) {
            responseDTO.setDataFail(listFail);
            responseDTO.setDataSuccess(listSuccess);
            responseDTO.setMessage("Insert Success and some record fail!!!");
        }
        return responseDTO;
    }
}
