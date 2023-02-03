package com.naver.ehd9567.hollys_backend.dto.categoryDto;

import com.naver.ehd9567.hollys_backend.dto.menuDto.MenuDTO;
import lombok.Data;

@Data
public class CategoryWithMenuTypeNameRes {

    private int category_id;
    private String type;
    private String name;
    private MenuDTO menuDTO;
}
