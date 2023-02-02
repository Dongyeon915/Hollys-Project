package com.naver.ehd9567.hollys_backend.dto.productDto;

import com.naver.ehd9567.hollys_backend.dto.categoryDto.CategoryDTO;
import com.naver.ehd9567.hollys_backend.dto.menuDto.MenuDTO;
import com.naver.ehd9567.hollys_backend.dto.productDto.ProductDTO;
import lombok.Data;

@Data
public class ProductResponse {
    private Integer product_id;
    private ProductDTO product;
    private MenuDTO menu;
    private CategoryDTO category;
}
