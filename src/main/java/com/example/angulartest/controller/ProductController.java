package com.example.angulartest.controller;

import com.example.angulartest.dto.ProductDto;
import com.example.angulartest.dto.UserGetDto;
import com.example.angulartest.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    private List<ProductDto> productDtoList;
    @Autowired
    private PermissionService permissionService;

    public ProductController() {
        productDtoList = init();
    }

    private List<ProductDto> init() {
        List<ProductDto> list = new ArrayList<>();
        String name = "product";
        String code = "code";
        Boolean isChecked = false;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                isChecked = true;
                list.add(new ProductDto(Long.valueOf(i), UUID.randomUUID().toString(), name + i, code + i, null, isChecked, false, null));
            } else {
                isChecked = false;
                list.add(new ProductDto(Long.valueOf(i), UUID.randomUUID().toString(), name + i, code + i, null, isChecked, false, null));
            }
        }
        return list;
    }

    /**
     * Danh sách các sản phẩm chưa xử lý hay đã xử lý
     * @param isChecked
     * @return
     */
    @GetMapping("/isChecked")
    public ResponseEntity getProductDtoListByChecked(@RequestParam("isChecked") String isChecked) {
        List<ProductDto> list = new ArrayList<>();
        Boolean isCheck = Boolean.valueOf(isChecked);
        for (int i = 0; i < productDtoList.size(); i++) {
            ProductDto productDto = productDtoList.get(i);
            if (productDto.getChecked().equals(isCheck)) {
                list.add(productDto);
            }
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }

    /**
     * Những sản phẩm có vấn đề
     * @param isProblem
     * @return
     */
    @GetMapping("/isProblem")
    public ResponseEntity getProductDtoListByProblemed(@RequestParam("isProblem") String isProblem) {
        List<ProductDto> list = new ArrayList<>();
        Boolean isProblemed = Boolean.valueOf(isProblem);
        for (int i = 0; i < productDtoList.size(); i++) {
            ProductDto productDto = productDtoList.get(i);
            if (productDto.getProblem().equals(isProblemed)) {
                list.add(productDto);
            }
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }

    /**
     * Cập nhật sản phẩm này có vấn đề
     * @param productDto
     * @return
     */
    @PutMapping("/edit")
    public ResponseEntity edit(@RequestBody ProductDto productDto) {
        for (int i = 0; i < productDtoList.size(); i++) {
            ProductDto productDto1 = productDtoList.get(i);
            if (productDto.getId().equals(productDto1.getId())) {
                productDto1.setProblem(productDto.getProblem());
                return new ResponseEntity(productDto1, HttpStatus.OK);
            }
        }
        return null;
    }
}
