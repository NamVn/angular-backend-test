package com.example.angulartest.service;

import com.example.angulartest.dao.entities.ProductEnt;
import com.example.angulartest.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProductService {
    ProductDto save(ProductDto productDto);

    void deleteById(Long id);

    Page<ProductDto> findByAll(Pageable pageable);

    List<ProductEnt> findByNameLikeAndStatus(String name,Integer status);
}
