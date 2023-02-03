package com.naver.ehd9567.hollys_backend.controller;

import com.naver.ehd9567.hollys_backend.dao.CategoryDAO;
import com.naver.ehd9567.hollys_backend.dto.categoryDto.CategoryDTO;
import com.naver.ehd9567.hollys_backend.dto.categoryDto.CategoryRes;
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
@RequestMapping("/categories")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {

    @Autowired
    private CategoryDAO categoryDAO;

    @Operation(summary = "모든 카테고리를 조회 합니다.",
        description = "모든 카테고리를 조회하는 동작을 수행합니다."
    )
    @GetMapping
    public List getAllCategory() {
        return categoryDAO.getAllCategory();
    }

    @Operation(summary = "카테고리의 ID를 조회합니다.",
        description = "카테고리의 ID를 조회하는 동작을 수행합니다.",
        parameters = {
            @Parameter(name = "id", description = "카테고리의 ID를 의미합니다.", example = "1")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "[성공] 해당 ID를 반환합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryDTO.class))),
            @ApiResponse(responseCode = "400", description = "[실패] 해당 ID를 조회할수 없습니다.", content = @Content(mediaType = "text/plain", examples = {
                @ExampleObject("해당하는 ID가 존재하지 않습니다.")}))
        }
    )
    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        CategoryDTO categoryDAOById = categoryDAO.getById(id);
        if (categoryDAOById == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("들어온 값이 없습니다");
        }
        return ResponseEntity.status(HttpStatus.OK).body(categoryDAOById);
    }

    @Operation(summary = "카테고리의 메뉴fK를 조회합니다.",
        description = "카테고리의 메뉴fK를 조회하는 동작을 수행합니다.",
        parameters = {
            @Parameter(name = "menu_fk", description = "카테고리의 menu_fk를 의미합니다.", example = "1")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "[성공] 해당 menu_fk를 반환합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryDTO.class))),
            @ApiResponse(responseCode = "400", description = "[실패] 해당 menu_fk를 조회할수 없습니다.", content = @Content(mediaType = "text/plain", examples = {
                @ExampleObject("해당하는 menu_fk가 존재하지 않습니다.")}))
        }
    )
    @GetMapping("/menufk/{menu_fk}")
    public ResponseEntity<Object> getByMenu_fk(@PathVariable Integer menu_fk) {
        List<CategoryDTO> menuFk = categoryDAO.getByMenu_fk(menu_fk);
        if (menuFk.size() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("값이 없습니다");
        }
        return ResponseEntity.status(HttpStatus.OK).body(menuFk);
    }


    @Operation(summary = "카테고리의 Type을 조회합니다.",
        description = "카테고리의 Type을 조회하는 동작을 수행합니다.",
        parameters = {
            @Parameter(name = "type", description = "카테고리의 DtoType을 의미합니다.", example = "에스프레소")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "[성공] 해당 Type을 반환합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryDTO.class))),
            @ApiResponse(responseCode = "400", description = "[실패] 해당 Type을 조회할수 없습니다.", content = @Content(mediaType = "text/plain", examples = {
                @ExampleObject("해당하는 Type이 존재하지 않습니다.")}))
        }
    )
    @GetMapping("/type/{type}")
    public ResponseEntity<Object> getByType(@PathVariable String type) {
        CategoryDTO categoryDTO = categoryDAO.getByType(type);
        return ResponseEntity.status(HttpStatus.OK).body(categoryDTO);
    }

    @Operation(summary = "카테고리를 추가 합니다.",
        description = "카테고리의 Type을 조회하는 동작을 수행합니다.",
        parameters = {
            @Parameter(name = "type", description = "카테고리의 Type을 의미합니다.")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "[성공] 추가한 카테고리를 반환합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryDTO.class))),
            @ApiResponse(responseCode = "400", description = "[실패] 해당 카테고리를 추가할수 없습니다.", content = @Content(mediaType = "text/plain", examples = {
                @ExampleObject("추가한 카테고리가 존재하지 않습니다.")}))
        }
    )
    @PostMapping
    public ResponseEntity<Object> setCategory(@RequestBody CategoryDTO setDTO) {
        int result = categoryDAO.setCategory(setDTO);
        if (result != 1) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("구성을 다시 확인 후 추가해주세요");
        }
        return ResponseEntity.status(HttpStatus.OK).body(setDTO);
    }

    @Operation(summary = "카테고리를 수정 합니다.",
        description = "카테고리를 수정하는 동작을 수행합니다.",
        parameters = {
            @Parameter(name = "putDTO", description = "카테고리의 CategoryDTO를 의미합니다.")
        },
        responses = {

            @ApiResponse(responseCode = "200", description = "[성공] 수정한 카테고리를 반환합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryDTO.class))),
            @ApiResponse(responseCode = "400", description = "[실패] 해당 카테고리를 수정할수 없습니다.", content = @Content(mediaType = "text/plain", examples = {
                @ExampleObject("수정한 카테고리가 존재하지 않습니다.")}))
        }
    )
    @PutMapping
    public ResponseEntity<Object> putCategory(@RequestBody CategoryDTO putDTO) {
        int result = categoryDAO.putCategory(putDTO);
        if (result != 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("수정할 값을 재 확인 해주세요.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(putDTO);
    }

    @Operation(summary = "카테고리를 삭제 합니다.",
        description = "카테고리를 삭제하는 동작을 수행합니다.",
        parameters = {
            @Parameter(name = "deleteDTO", description = "카테고리의 CategoryDTO를 의미합니다.")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "[성공] 해당 카테고리를 삭제 합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryDTO.class))),
            @ApiResponse(responseCode = "400", description = "[실패] 해당 카테고리를 삭제할수 없습니다.", content = @Content(mediaType = "text/plain", examples = {
                @ExampleObject("삭제할 카테고리가 존재하지 않습니다.")}))
        }
    )
    @DeleteMapping("/{category_id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable int category_id) {
        int result = categoryDAO.deleteCategory(category_id);
        if (result != 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("삭제 값을 재 확인 해주세요.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(category_id);
    }

    @GetMapping("/detailCategoryMenu/{id}")
    public CategoryRes getCategoryWithMenu(@PathVariable int id){
        return categoryDAO.getCategoryWithMenu(id);
    }
}
