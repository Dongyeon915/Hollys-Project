package com.naver.ehd9567.hollys_backend.controller;

import com.naver.ehd9567.hollys_backend.dao.MenuDAO;
import com.naver.ehd9567.hollys_backend.dto.menuDto.MenuDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "menu", description = "메뉴에 관련된 동작을 수행하는 API")
@RestController
@RequestMapping("/menus")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MenuController {

    @Autowired
    private MenuDAO menuDAO;

    @Operation(summary = "모든 메뉴를 조회한다.",
        description = "모든 메뉴를 조회하는 동작을 수행합니다.",
        responses = {
            @ApiResponse(responseCode = "200", description = "[성공] 모든 메뉴를 반환합니다.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MenuDTO.class)), examples = {
                @ExampleObject(value = "[{\"menu_id\":1,\"name\":\"Coffee\"},{\"menu_id\":2,\"name\":\"Beverage\"},{\"menu_id\":3,\"name\":\"Food\"},{\"menu_id\":4,\"name\":\"Snack\"}]")
            }))
        }
    )
    @GetMapping
    public List<MenuDTO> getAllMenu() {
        return menuDAO.getAllMenu();
    }

    @Operation(summary = "ID로 메뉴를 조회한다.",
        description = "ID로 메뉴를 조회하는 동작을 수행합니다.",
        parameters = {
            @Parameter(name = "id", description = "메뉴의 ID를 의미합니다.", example = "1")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "[성공] ID에 해당하는 메뉴를 반환합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuDTO.class))),
            @ApiResponse(responseCode = "400", description = "[실패] ID에 해당하는 메뉴가 존재하지 않습니다.", content = @Content(mediaType = "text/plain", examples = {
                @ExampleObject("ID에 해당하는 메뉴가 존재하지 않습니다.")}))
        }
    )
    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getMenuById(@Valid @PathVariable Integer id) {
        MenuDTO menuDTOId = menuDAO.getMenuById(id);
        if (menuDTOId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID에 해당하는 메뉴가 존재하지 않습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(menuDTOId);
        }
    }

    @Operation(summary = "메뉴명으로 메뉴를 조회한다.",
        description = "메뉴명으로 메뉴를 조회하는 동작을 수행합니다.",
        parameters = {
            @Parameter(name = "name", description = "메뉴명을 의미합니다.", example = "Coffee")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "[성공] 메뉴명에 해당하는 메뉴를 반환합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuDTO.class))),
            @ApiResponse(responseCode = "400", description = "[실패] ID에 해당하는 메뉴가 존재하지 않습니다.", content = @Content(mediaType = "text/plain", examples = {
                @ExampleObject("요청하신 {메뉴}가 존재하지 않습니다.")}))
        }
    )
    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getMenuByName(@Valid @PathVariable String name) {
        MenuDTO menuName = menuDAO.getMenuByName(name);
        if (menuName == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("요청하신" + name + " 가 존재하지 않습니다.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(menuName);
    }

    @Operation(summary = "새로운 메뉴를 등록한다.",
        description = "메뉴를 등록합니다.",
        parameters = {
            @Parameter(name = "MenuDTO", description = "menuDTO 타입을 의미합니다.")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "[성공] 메뉴명에 새로운 메뉴를 등록합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuDTO.class))),
            @ApiResponse(responseCode = "400", description = "[실패] 등록 정보의 오류가 있습니다..", content = @Content(mediaType = "text/plain", examples = {
                @ExampleObject("메뉴 입력을 다시 확인해주세요.")}))
        }
    )
    @PostMapping
    public ResponseEntity<Object> setMenu(@RequestBody @Valid MenuDTO menuDTO) {
        int menu = menuDAO.setMenu(menuDTO);
        if (menu != 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("메뉴 입력을 다시 확인해주세요");
        }
        return ResponseEntity.status(HttpStatus.OK).body(menuDTO);
    }

    @Operation(summary = "메뉴를 수정한다.",
        description = "메뉴를 수정합니다.",
        parameters = {
            @Parameter(name = "MenuDTO", description = "menuDTO 타입을 의미합니다.")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "[성공] 메뉴를 수정합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuDTO.class))),
            @ApiResponse(responseCode = "400", description = "[실패] 등록 정보의 오류가 있습니다..", content = @Content(mediaType = "text/plain", examples = {
                @ExampleObject("메뉴 입력을 다시 확인해주세요.")}))
        }
    )
    @PutMapping
    public ResponseEntity<Object> updateMenu(@Valid @RequestBody MenuDTO menuDTO) {
        int result = menuDAO.updateMenu(menuDTO);
        if (result != 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("값을 재 확인 해주세요.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(menuDTO);
    }

    @Operation(summary = "메뉴를 삭제 합니다.",
        description = "메뉴를 삭제 합니다.",
        parameters = {
            @Parameter(name = "MenuDTO", description = "menuDTO 타입을 의미합니다.")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "[성공] 메뉴를 삭제합니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuDTO.class))),
            @ApiResponse(responseCode = "400", description = "[실패] ID 오류가 있습니다..", content = @Content(mediaType = "text/plain", examples = {
                @ExampleObject("ID 입력을 다시 확인해주세요.")}))
        }
    )
    @DeleteMapping("/{menu_id}")
    public ResponseEntity<Object> deleteMenu(@Valid @PathVariable Integer menu_id) {
        int result = menuDAO.deleteMenu(menu_id);
        if (result != 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("삭제하는 값을 확인 해주세요");
        }
        return ResponseEntity.status(HttpStatus.OK).body(menu_id);
    }

//    @GetMapping("/{id}/menus")
//    public Object getCategoryWithMenusById(@PathVariable int id) {
//        return menuDAO.getCategoryWithMenusById(id);
//    }

    @GetMapping("/detail/{id}")
    public Object menuDetail(@PathVariable int id){
        return menuDAO.getMenuDetail(id);
    }
}
