package com.naver.ehd9567.hollys_backend.controller;

import com.naver.ehd9567.hollys_backend.dao.ProductDAO;
import com.naver.ehd9567.hollys_backend.dto.MenuDTO;
import com.naver.ehd9567.hollys_backend.dto.ProductDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private ProductDAO productDAO;

  @Operation(summary = "모든 상품을 조회합니다.",
      description = "상품을 조회하는 동작을 수행합니다.",
//      parameters = {
//          @Parameter(name = "id", description = "메뉴의 ID를 의미합니다.", example = "1")
//      },
      responses = {
          @ApiResponse(responseCode = "200", description = "[성공] 모든 상품를 반환합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuDTO.class))),
          @ApiResponse(responseCode = "400", description = "[실패] 상품을 조회할수 없습니다.", content = @Content(mediaType = "text/plain", examples = {
              @ExampleObject("해당하는 상품이 존재하지 않습니다.")}))
      }
  )
  @GetMapping("/getAllProduct")
  public List<ProductDTO> getAllProduct() {
    return productDAO.getAllProduct();
  }

}
