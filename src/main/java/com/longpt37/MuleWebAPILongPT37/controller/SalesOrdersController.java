package com.longpt37.MuleWebAPILongPT37.controller;

import com.longpt37.MuleWebAPILongPT37.dto.ResponseDTO;
import com.longpt37.MuleWebAPILongPT37.dto.SalesOrders;
import com.longpt37.MuleWebAPILongPT37.request.SORequest;
import com.longpt37.MuleWebAPILongPT37.services.SalesOrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("so")
public class SalesOrdersController {
    private final SalesOrdersService soService;
    @PostMapping
    public ResponseEntity<ResponseDTO> insertSO(@RequestBody SORequest so) throws ParseException {
        ResponseDTO<SalesOrders> responseDTO = soService.insertSO(so);
        return ResponseEntity.ok().body(responseDTO);
    }
}
