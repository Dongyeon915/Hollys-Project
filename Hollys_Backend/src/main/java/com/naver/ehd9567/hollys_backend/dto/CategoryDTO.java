package com.naver.ehd9567.hollys_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "카테고리를 나타내는 Class를 의미합니다.")
@Data
public class CategoryDTO {

  private Integer category_id;
  private Integer menu_fk;
  private String type;
}
