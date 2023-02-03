package com.naver.ehd9567.hollys_backend.dto.productDto;

import com.naver.ehd9567.hollys_backend.dto.categoryDto.CategoryDTO;
import lombok.Data;

@Data
public class ProductResTest {

    private int id;
    private String name;
    private int price;
    private CategoryDTO categoryDTO;
}
