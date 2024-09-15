package com.longpt37.MuleWebAPILongPT37.servicesImplement;

import com.longpt37.MuleWebAPILongPT37.dto.PurchaseOrders;
import com.longpt37.MuleWebAPILongPT37.dto.ResponseDTO;
import com.longpt37.MuleWebAPILongPT37.repository.PurchaseOrderRepository;
import com.longpt37.MuleWebAPILongPT37.request.PORequest;
import com.longpt37.MuleWebAPILongPT37.services.PurchaseOrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RequiredArgsConstructor
@Service
public class PurchaseOrdersServiceImplement implements PurchaseOrdersService {
    private final PurchaseOrderRepository purchaseOrderRepository;
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
    @Override
    public ResponseDTO<PurchaseOrders> insertPO(PORequest request) throws ParseException {
        ResponseDTO<PurchaseOrders> responseDTO = new ResponseDTO<>();

        PurchaseOrders tmp = purchaseOrderRepository.findByOrderNoAndOrderDate(request.getOrderNo(), convertDate(request.getOrderDate()));
        if(tmp != null){
            responseDTO.setStatus("500");
            responseDTO.setData(tmp);
            responseDTO.setMessage("Data existed!!!");
            return responseDTO;
        }
        tmp = PurchaseOrders.builder()
                .description(request.getDescription())
                .orderNo(request.getOrderNo())
                .title(request.getTitle())
                .orderDate(convertDate(request.getOrderDate()))
                .createdDate(convertDate(request.getCreatedDate()))
                .createdBy("LongPT37")
                .build();
        purchaseOrderRepository.save(tmp);
        responseDTO.setStatus("200");
        responseDTO.setData(tmp);
        responseDTO.setMessage("Insert Success!!!");
        return responseDTO;
    }
    public Date convertDate(String date) throws ParseException {
        Date tmp = new Date(formatter.parse(date).getTime());
        return tmp;
    }
}
