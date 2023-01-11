package com.naver.ehd9567.hollys_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "카테고리를 나타내는 Class를 의미합니다.")
@Data
public class CategoryDTO {

  @Schema(description = "카테고리의 ID를 의미합니다.", example = "1")
  private Integer category_id;
  @Schema(description = "메뉴테이블의 서브키를 의미합니다.", example = "1")
  private Integer menu_fk;
  @Schema(description = "카테고리의 타입를 의미합니다.", example = "에스프레소")
  private String type;
}
