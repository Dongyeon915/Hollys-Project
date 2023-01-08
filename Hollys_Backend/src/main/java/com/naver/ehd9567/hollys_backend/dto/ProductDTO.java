package com.naver.ehd9567.hollys_backend.dto;

import lombok.Data;

@Data
public class ProductDTO {
  private Integer id;
  private String name;
  private String name_eng;
  private Integer price;
  private String image_url;
}
