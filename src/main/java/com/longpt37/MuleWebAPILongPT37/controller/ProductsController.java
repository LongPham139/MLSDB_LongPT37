package com.longpt37.MuleWebAPILongPT37.controller;

import com.longpt37.MuleWebAPILongPT37.dto.Products;
import com.longpt37.MuleWebAPILongPT37.services.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.LongPT37.MuleWebAPI.model.ListResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductsController {
    private final ProductsService productsService;
    @GetMapping()
    public ResponseEntity<ListResponseDTO> getAllProducts(){
        ListResponseDTO<Products> listResponseDTO = new ListResponseDTO<Products>();
        List<Products> list = productsService.getAllProducts();
        listResponseDTO.setData(list);
        if(list == null){
            listResponseDTO.setMessage("Get Fail");
            listResponseDTO.setStatus("500");
        }
        else{
            listResponseDTO.setMessage("Success");
            listResponseDTO.setStatus("200");
        }
        listResponseDTO.setData(list);
        return ResponseEntity.ok().body(listResponseDTO);
    }
}
