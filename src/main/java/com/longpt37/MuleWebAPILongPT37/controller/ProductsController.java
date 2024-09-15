package com.longpt37.MuleWebAPILongPT37.controller;

import com.longpt37.MuleWebAPILongPT37.dto.Products;
import com.longpt37.MuleWebAPILongPT37.dto.ResponseDTO;
import com.longpt37.MuleWebAPILongPT37.request.ProductRequest;
import com.longpt37.MuleWebAPILongPT37.request.ProductUpdateRequest;
import com.longpt37.MuleWebAPILongPT37.services.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.longpt37.MuleWebAPILongPT37.dto.ListResponseDTO;


import java.text.ParseException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductsController {
    private final ProductsService productsService;
    @GetMapping()
    public ResponseEntity<ListResponseDTO> getAllProducts(){
        ListResponseDTO<Products> listResponseDTO = new ListResponseDTO<>();
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
    @PostMapping()
    public ResponseEntity<ResponseDTO> insertProduct(@RequestBody ProductRequest products) throws ParseException {
        ResponseDTO<Products> responseDTO = productsService.insertProducts(products);
        return ResponseEntity.ok().body(responseDTO);
    }
    @PutMapping()
    public ResponseEntity<ResponseDTO> updatePODProduct(@RequestBody ProductUpdateRequest products){
        ResponseDTO<Products> responseDTO = productsService.updatePODProduct(products.getProductCode(), products.getOrderNo(), products.getQuantityInStock());
        return ResponseEntity.ok().body(responseDTO);
    }
}
