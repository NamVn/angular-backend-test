package com.example.angulartest.dao.idao;

import com.example.angulartest.dao.entities.ProductEnt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEnt, Long> {
    List<ProductEnt> findByNameLikeAndStatus(String name, Integer status);
}
