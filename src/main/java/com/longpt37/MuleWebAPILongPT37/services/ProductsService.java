package com.longpt37.MuleWebAPILongPT37.services;

import com.longpt37.MuleWebAPILongPT37.dto.Products;
import com.longpt37.MuleWebAPILongPT37.dto.ResponseDTO;
import com.longpt37.MuleWebAPILongPT37.request.ProductRequest;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
@Service
public interface ProductsService {
    List<Products> getAllProducts();
    ResponseDTO<Products> insertProducts(ProductRequest products) throws ParseException;
    ResponseDTO<Products> updatePODProduct(String productCode, String orderNo, double quantityInStock);
    ResponseDTO<Products> updateSODProduct(String productCode, String orderNo, double quantityInStock);
}
