package com.longpt37.MuleWebAPILongPT37.servicesImplement;

import com.longpt37.MuleWebAPILongPT37.dto.ListResponseSOD;
import com.longpt37.MuleWebAPILongPT37.dto.PurchaseOrderDetails;
import com.longpt37.MuleWebAPILongPT37.dto.ResponseDTO;
import com.longpt37.MuleWebAPILongPT37.dto.SalesOrderDetails;
import com.longpt37.MuleWebAPILongPT37.repository.PurchaseOrderDetailsRepository;
import com.longpt37.MuleWebAPILongPT37.request.ListPODRequest;
import com.longpt37.MuleWebAPILongPT37.request.ListSODRequest;
import com.longpt37.MuleWebAPILongPT37.request.PODRequest;
import com.longpt37.MuleWebAPILongPT37.request.SODRequest;
import com.longpt37.MuleWebAPILongPT37.services.PurchaseOrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseOrderDetailsServiceImplement implements PurchaseOrderDetailsService {
    private final PurchaseOrderDetailsRepository purchaseOrderDetailsRepository;
    @Override
    public ResponseDTO<PurchaseOrderDetails> insertPOD(PODRequest request) {
        ResponseDTO<PurchaseOrderDetails> responseDTO = new ResponseDTO<>();
        PurchaseOrderDetails pod = purchaseOrderDetailsRepository.findByOrderNoAndProductCodeAndPurchasePrice(request.getOrderNo(), request.getProductCode(), request.getPurchasePrice());
        if(pod != null){
            responseDTO.setStatus("500");
            responseDTO.setData(pod);
            responseDTO.setMessage("Data existed!!!");
            return responseDTO;
        }
        pod = PurchaseOrderDetails.builder()
                .orderNo(request.getOrderNo())
                .purchasePrice(request.getPurchasePrice())
                .tax(request.getTax())
                .productCode(request.getProductCode())
                .quantity(request.getQuantity())
                .build();
        purchaseOrderDetailsRepository.save(pod);
        responseDTO.setStatus("200");
        responseDTO.setData(pod);
        responseDTO.setMessage("Insert Successful!!!");
        return responseDTO;
    }

    @Override
    public ListResponseSOD<PurchaseOrderDetails> insertPODs(ListPODRequest requests) {
        ListResponseSOD<PurchaseOrderDetails> responseDTO = new ListResponseSOD<>();
        List<PODRequest> list = requests.getListPOD();
        List<PurchaseOrderDetails> listSuccess = new ArrayList<>();
        List<PurchaseOrderDetails> listFail = new ArrayList<>();
        if (requests == null) {
            responseDTO.setStatus("500");
            responseDTO.setMessage("List is empty!!!");
            return responseDTO;
        }
        for (int i = 0; i < list.size(); i++) {
            PurchaseOrderDetails pod = purchaseOrderDetailsRepository.findByOrderNoAndProductCodeAndPurchasePrice(list.get(i).getOrderNo(), list.get(i).getProductCode(), list.get(i).getPurchasePrice());
            if (pod != null) {
                listFail.add(pod);
            } else {
                pod = PurchaseOrderDetails.builder()
                        .orderNo(list.get(i).getOrderNo())
                        .productCode(list.get(i).getProductCode())
                        .purchasePrice(list.get(i).getPurchasePrice())
                        .quantity(list.get(i).getQuantity())
                        .tax(list.get(i).getTax())
                        .build();
                purchaseOrderDetailsRepository.save(pod);
                listSuccess.add(pod);
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
