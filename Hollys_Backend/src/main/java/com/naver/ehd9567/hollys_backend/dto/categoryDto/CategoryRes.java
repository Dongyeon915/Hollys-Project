package com.naver.ehd9567.hollys_backend.dto.categoryDto;

import com.naver.ehd9567.hollys_backend.dto.menuDto.MenuDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryRes {

    private Integer category_id;
    private Integer menu_fk;
    private String type;
    private MenuDTO menuDTO;
}
