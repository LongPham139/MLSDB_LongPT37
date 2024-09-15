package com.longpt37.MuleWebAPILongPT37.controller;

import com.longpt37.MuleWebAPILongPT37.dto.ListResponseSOD;
import com.longpt37.MuleWebAPILongPT37.dto.ResponseDTO;
import com.longpt37.MuleWebAPILongPT37.dto.SalesOrderDetails;
import com.longpt37.MuleWebAPILongPT37.request.ListSODRequest;
import com.longpt37.MuleWebAPILongPT37.request.SODRequest;
import com.longpt37.MuleWebAPILongPT37.services.SalesOrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("sod")
public class SalesOrderDetailsController {
    private final SalesOrderDetailsService sodService;
    @PostMapping
//    public ResponseEntity<ResponseDTO> insertSOD(@RequestBody SODRequest sod){
//        ResponseDTO<SalesOrderDetails> responseDTO = sodService.insertSOD(sod);
//        return ResponseEntity.ok().body(responseDTO);
//    }
    public ResponseEntity<ListResponseSOD> insertSODs(@RequestBody ListSODRequest sod){
        ListResponseSOD<SalesOrderDetails> responseSOD = sodService.insertSODs(sod);
        return ResponseEntity.ok().body(responseSOD);
    }
}
