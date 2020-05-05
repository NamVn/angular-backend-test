package com.example.angulartest.dao.entities;

import com.example.angulartest.dto.EntDto;
import com.example.angulartest.dto.PermissionDto;
import com.example.angulartest.dto.ProductDto;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResultUtils;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "product")
public class ProductEnt extends EntBase<ProductDto> {
    private String name;
    private String code;
    private String description;
    /**
     * 0 là chưa xử lý
     * 1 là đã xử lý
     * 2 là xem xét lại
     */
    private Integer status = 0;
    private Boolean isProblem;
    private String note;

    public ProductEnt() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Boolean getProblem() {
        return isProblem;
    }

    public void setProblem(Boolean problem) {
        isProblem = problem;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    @Override
    public ProductDto getAsDto() {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(this, productDto);
        return productDto;
    }
}
