package com.naver.ehd9567.hollys_backend.dto.categoryDto;

import java.awt.Menu;
import java.util.List;
import lombok.Data;

@Data
public class CategoryWithMenuRes {
    private Integer category_id;
    private Integer menu_fk;
    private String type;
    private List<Menu> menus;
}
