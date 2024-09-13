package com.longpt37.MuleWebAPILongPT37.servicesImplement;

import com.longpt37.MuleWebAPILongPT37.dto.Products;
import com.longpt37.MuleWebAPILongPT37.repository.ProductRepository;
import com.longpt37.MuleWebAPILongPT37.services.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductsServiceImplement implements ProductsService {
    private final ProductRepository productRepository;
    @Override
    public List<Products> getAllProducts() {
        List<Products> list = productRepository.findAll();
        if(!list.isEmpty()){
            return list;
        }
        return null;
    }
}
