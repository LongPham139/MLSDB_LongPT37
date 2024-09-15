package com.longpt37.MuleWebAPILongPT37.controller;

import com.longpt37.MuleWebAPILongPT37.dto.ListResponseSOD;
import com.longpt37.MuleWebAPILongPT37.dto.PurchaseOrderDetails;
import com.longpt37.MuleWebAPILongPT37.dto.ResponseDTO;
import com.longpt37.MuleWebAPILongPT37.dto.SalesOrderDetails;
import com.longpt37.MuleWebAPILongPT37.request.ListPODRequest;
import com.longpt37.MuleWebAPILongPT37.request.ListSODRequest;
import com.longpt37.MuleWebAPILongPT37.request.PODRequest;
import com.longpt37.MuleWebAPILongPT37.services.PurchaseOrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("pod")
public class PurchaseOrderDetailsController {
    private final PurchaseOrderDetailsService podService;
    @PostMapping
//    public ResponseEntity<ResponseDTO> insertPOD(@RequestBody PODRequest pod){
//        ResponseDTO<PurchaseOrderDetails> responseDTO = podService.insertPOD(pod);
//        return ResponseEntity.ok().body(responseDTO);
//    }
    public ResponseEntity<ListResponseSOD> insertSODs(@RequestBody ListPODRequest pod){
        ListResponseSOD<PurchaseOrderDetails> responseSOD = podService.insertPODs(pod);
        return ResponseEntity.ok().body(responseSOD);
    }
}
