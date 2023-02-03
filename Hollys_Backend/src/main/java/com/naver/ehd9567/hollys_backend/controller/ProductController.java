package com.naver.ehd9567.hollys_backend.controller;

import com.naver.ehd9567.hollys_backend.dao.ProductDAO;
import com.naver.ehd9567.hollys_backend.dto.productDto.ProductDTO;
import com.naver.ehd9567.hollys_backend.dto.productDto.ProductRes;
import com.naver.ehd9567.hollys_backend.dto.productDto.ProductResTest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @Operation(summary = "모든 상품을 조회합니다.",
        description = "상품을 조회하는 동작을 수행합니다.",
        responses = {
            @ApiResponse(responseCode = "200", description = "[성공] 모든 상품를 반환합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class))),
            @ApiResponse(responseCode = "400", description = "[실패] 상품을 조회할수 없습니다.", content = @Content(mediaType = "text/plain", examples = {
                @ExampleObject("해당하는 상품이 존재하지 않습니다.")}))
        }
    )
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Operation(summary = "상품의 ID를 조회합니다.",
        description = "상품을 조회하는 동작을 수행합니다.",
        parameters = {
            @Parameter(name = "id", description = "상품의 ID를 의미합니다.", example = "1")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "[성공] 해당 ID 상품를 반환합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class))),
            @ApiResponse(responseCode = "400", description = "[실패] 해당 ID를 조회할수 없습니다.", content = @Content(mediaType = "text/plain", examples = {
                @ExampleObject("해당하는 상품의 ID가 존재하지 않습니다.")}))
        }
    )

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getProductById(@Valid @PathVariable Integer id) {
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
            @ApiResponse(responseCode = "200", description = "[성공] 해당 이름의 상품를 반환합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class))),
            @ApiResponse(responseCode = "400", description = "[실패] 해당 이름의 상품을 조회할수 없습니다.", content = @Content(mediaType = "text/plain", examples = {
                @ExampleObject("해당하는 이름의 상품이 존재하지 않습니다.")}))
        }
    )
    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getProductByName(@Valid @PathVariable String name) {
        ProductDTO productDTO = productDAO.getProductByName(name);
        if (productDTO == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이름을 다시 확인 해주세요.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productDTO);
    }

    @Operation(summary = "새로운 상품을 등록합니다..",
        description = "새로운 상품을 등록하는 동작을 수행합니다.",
        responses = {
            @ApiResponse(responseCode = "200", description = "[성공] 새로 등록한 상품를 반환합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class))),
            @ApiResponse(responseCode = "400", description = "[실패] 해당 상품을 등록할수 없습니다.", content = @Content(mediaType = "text/plain", examples = {
                @ExampleObject("해당하는 상품이 등록되지 않았습니다.")}))
        }
    )
    @PostMapping
    public ResponseEntity<Object> setProduct(@Valid @RequestBody ProductDTO product) {
        int productDTO = productDAO.setProduct(product);
        if (productDTO != 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("항목을 다시 입력해주세요.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @Operation(summary = "상품을 수정합니다..",
        description = "기존 상품을 수정하는 동작을 수행합니다.",
        responses = {
            @ApiResponse(responseCode = "200", description = "[성공] 수정된 상품를 반환합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class))),
            @ApiResponse(responseCode = "400", description = "[실패] 해당 상품을 수정할수 없습니다.", content = @Content(mediaType = "text/plain", examples = {
                @ExampleObject("해당하는 상품이 수정되지 않았습니다.")}))
        }
    )
    @PutMapping
    public ResponseEntity<Object> putProduct(@Valid @RequestBody ProductDTO putID) {
        int result = productDAO.putProduct(putID);
        if (result != 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("입력 값을 확인 해주세요.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(putID);
    }

    @Operation(summary = "상품을 삭제합니다..",
        description = "기존 상품을 삭제하는 동작을 수행합니다.",
        responses = {
            @ApiResponse(responseCode = "200", description = "[성공] 삭제된 상품를 반환합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class))),
            @ApiResponse(responseCode = "400", description = "[실패] 해당 상품을 삭제할수 없습니다.", content = @Content(mediaType = "text/plain", examples = {
                @ExampleObject("해당하는 상품이 삭제되지 않았습니다.")}))
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@Valid @PathVariable Integer id) {
        int productDTO = productDAO.deleteProduct(id);
        if (productDTO != 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("삭제 값을 확인 해주세요.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }

    @GetMapping("/details/{id}")
    public Object getProductMap(@PathVariable Integer id) {
        return productDAO.getProductMap(id);
    }


    @GetMapping("/details")
    public List<ProductRes> getAllProductInfos() {
        return productDAO.getProductInfos();
    }

    @GetMapping("/withCategoryType")
    public List<ProductResTest> getProductWithCategoryType() {
        return productDAO.getProductWithCategoryType();
    }
}
