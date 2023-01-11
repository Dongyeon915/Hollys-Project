package com.naver.ehd9567.hollys_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "상품를 나타내는 Class를 의미합니다.")
@Data
public class ProductDTO {

  @Schema(description = "상품의 ID를 의미합니다.", example = "1")
  private Integer id;
  @Schema(description = "상품의 이름를 의미합니다.", example = "프리미엄 블렌드 아메리카노")
  private String name;
  @Schema(description = "상품의 영어 이름를 의미합니다.", example = "Premium Blend Americano")
  private String name_eng;
  @Schema(description = "상품의 설명을 의미합니다.", example = "화사한 산미와 과일과 같은 달콤함, 깔끔한 후미를 즐길수 있는 커피")
  private String info;
  @Schema(description = "상품의 가격을 의미합니다.", example = "4900")
  private Integer price;
  @Schema(description = "상품의 이미지 주소를 의미합니다.", example = "https://admin.hollys.co.kr/upload/menu/etc/menuEtc_202205100954143020.png")
  private String image_url;
  @Schema(description = "카테고리 테이블의 서브키를 의미합니다.", example = "1")
  private Integer category_fk;
}
