package com.naver.ehd9567.hollys_backend.dto;

import lombok.Data;

@Data
public class CategoryDTO {
  private Integer category_id;
  private Integer menu_fk;
  private String type;
}
