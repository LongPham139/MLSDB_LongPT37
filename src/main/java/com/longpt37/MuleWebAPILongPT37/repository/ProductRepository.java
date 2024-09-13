package com.longpt37.MuleWebAPILongPT37.repository;

import com.longpt37.MuleWebAPILongPT37.dto.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

}
