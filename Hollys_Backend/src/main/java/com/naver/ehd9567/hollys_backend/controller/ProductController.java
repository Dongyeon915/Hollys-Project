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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductDAO productDAO;

  @Operation(summary = "모든 상품을 조회합니다.",
      description = "상품을 조회하는 동작을 수행합니다.",
      responses = {
          @ApiResponse(responseCode = "200", description = "[성공] 모든 상품를 반환합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuDTO.class))),
          @ApiResponse(responseCode = "400", description = "[실패] 상품을 조회할수 없습니다.", content = @Content(mediaType = "text/plain", examples = {
              @ExampleObject("해당하는 상품이 존재하지 않습니다.")}))
      }
  )
  @GetMapping("/getAllProduct")
  public List<ProductDTO> getAllProducts() {
    return productDAO.getAllProducts();
  }

  @Operation(summary = "상품의 ID를 조회합니다.",
      description = "상품을 조회하는 동작을 수행합니다.",
      parameters = {
          @Parameter(name = "id", description = "상품의 ID를 의미합니다.", example = "1")
      },
      responses = {
          @ApiResponse(responseCode = "200", description = "[성공] 해당 ID 상품를 반환합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuDTO.class))),
          @ApiResponse(responseCode = "400", description = "[실패] 해당 ID를 조회할수 없습니다.", content = @Content(mediaType = "text/plain", examples = {
              @ExampleObject("해당하는 상품의 ID가 존재하지 않습니다.")}))
      }
  )

  @GetMapping("/id/{id}")
  public ResponseEntity<Object> getProductById(@PathVariable int id) {
    ProductDTO result = productDAO.getProductById(id);
    if (result == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("존재하지 않는 Id입니다");
    }
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  @Operation(summary = "상품의 이름를 조회합니다.",
      description = "상품의 이름을 조회하는 동작을 수행합니다.",
      parameters = {
          @Parameter(name = "name", description = "상품의 이름를 의미합니다.", example = "카페라떼")
      },
      responses = {
          @ApiResponse(responseCode = "200", description = "[성공] 해당 이름의 상품를 반환합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuDTO.class))),
          @ApiResponse(responseCode = "400", description = "[실패] 해당 이름의 상품을 조회할수 없습니다.", content = @Content(mediaType = "text/plain", examples = {
              @ExampleObject("해당하는 이름의 상품이 존재하지 않습니다.")}))
      }
  )
  @GetMapping("/name/{name}")
  public ResponseEntity<Object> getProductByName(@PathVariable String name) {
    ProductDTO productDTO = productDAO.getProductByName(name);
    if (productDTO == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이름을 다시 확인 해주세요.");
    }
    return ResponseEntity.status(HttpStatus.OK).body(productDTO);
  }

}
