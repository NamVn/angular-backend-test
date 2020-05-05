package com.example.angulartest.service.impl;

import com.example.angulartest.dao.entities.ProductEnt;
import com.example.angulartest.dao.idao.ProductRepository;
import com.example.angulartest.dto.ProductDto;
import com.example.angulartest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto save(ProductDto productDto) {
        return productRepository.save(productDto.convertToEnt()).getAsDto();
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<ProductDto>



    findByAll(Pageable pageable) {
        Page<ProductEnt> productEntPage = productRepository.findAll(pageable);
        if (productEntPage != null) {
            Page<ProductDto> productDtoPage = productEntPage.map(new Function<ProductEnt, ProductDto>() {
                @Override
                public ProductDto apply(ProductEnt productEnt) {
                    return productEnt.getAsDto();
                }
            });
            return productDtoPage;
        }
        return null;
    }

    @Override
    public List<ProductEnt> findByNameLikeAndStatus(String name) {
        return productRepository.findByNameLike(name);
    }
}
