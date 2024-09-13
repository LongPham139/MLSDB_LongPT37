package com.longpt37.MuleWebAPILongPT37.services;

import com.longpt37.MuleWebAPILongPT37.dto.Products;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductsService {
    List<Products> getAllProducts();
}
