package com.naver.ehd9567.hollys_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "메뉴를 나타내는 Class를 의미합니다.")
@Data
public class MenuDTO {

    @Schema(description = "메뉴의 ID를 의미합니다.", example = "1")
    private Integer menu_id;
    @Schema(description = "메뉴명을 의미합니다.", example = "Coffee")
    private String name;
}
