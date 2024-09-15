package com.longpt37.MuleWebAPILongPT37.controller;

import com.longpt37.MuleWebAPILongPT37.dto.Products;
import com.longpt37.MuleWebAPILongPT37.dto.PurchaseOrders;
import com.longpt37.MuleWebAPILongPT37.dto.ResponseDTO;
import com.longpt37.MuleWebAPILongPT37.request.PORequest;
import com.longpt37.MuleWebAPILongPT37.request.ProductRequest;
import com.longpt37.MuleWebAPILongPT37.services.PurchaseOrdersService;
import com.longpt37.MuleWebAPILongPT37.servicesImplement.PurchaseOrdersServiceImplement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("purchaseOrders")
public class PurchaseOrdersController {
    private final PurchaseOrdersService purchaseOrdersService;
    @PostMapping
    public ResponseEntity<ResponseDTO> insertProduct(@RequestBody PORequest request) throws ParseException {
        System.out.println(request);
        ResponseDTO<PurchaseOrders> responseDTO = purchaseOrdersService.insertPO(request);
        return ResponseEntity.ok().body(responseDTO);
    }
}
