package com.naver.ehd9567.hollys_backend.dto.categoryDto;

import lombok.Data;

@Data
public class CategoryRes {

    private Integer category_id;
    private Integer menu_fk;
    private String type;
}
