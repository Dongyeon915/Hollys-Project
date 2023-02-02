package com.naver.ehd9567.hollys_backend.dto.productDto;

import com.naver.ehd9567.hollys_backend.dto.categoryDto.CategoryDTO;
import com.naver.ehd9567.hollys_backend.dto.menuDto.MenuDTO;
import lombok.Data;

@Data
public class ProductRes {
    private Integer id;
    private String name;
    private String name_eng;
    private String info;
    private Integer price;
    private String image_url;
    private MenuDTO menu;
    private CategoryDTO category;
}
