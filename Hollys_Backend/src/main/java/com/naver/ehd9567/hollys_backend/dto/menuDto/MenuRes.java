package com.naver.ehd9567.hollys_backend.dto.menuDto;

import com.naver.ehd9567.hollys_backend.dto.categoryDto.CategoryDTO;
import java.util.List;
import lombok.Data;

@Data
public class
MenuRes {
    private int menu_id;
    private String name;
    List<CategoryDTO> categories;
}
