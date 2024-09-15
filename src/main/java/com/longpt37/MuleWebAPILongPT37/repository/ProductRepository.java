package com.longpt37.MuleWebAPILongPT37.repository;

import com.longpt37.MuleWebAPILongPT37.dto.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM PRODUCTS")
    List<Products> getAll();
    @Query(nativeQuery = true, value = "SELECT * FROM PRODUCTS WHERE PRODUCTCODE = :productCode AND UNITPRICE = :unitPrice")
    Products findByProductCodeAnd(String productCode, double unitPrice);
    Products findByProductCode(String productCode);
}
