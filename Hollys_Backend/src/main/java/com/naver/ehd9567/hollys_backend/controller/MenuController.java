package com.naver.ehd9567.hollys_backend.controller;

import com.naver.ehd9567.hollys_backend.dao.MenuDAO;
import com.naver.ehd9567.hollys_backend.dto.MenuDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "menu", description = "메뉴에 관련된 동작을 수행하는 API")
@RestController
@RequestMapping("/menus")
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
    public ResponseEntity<Object> getMenuById(@PathVariable Integer id) {
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
    public ResponseEntity<Object> getMenuByName(@PathVariable("name") String name) {
        MenuDTO menuName = menuDAO.getMenuByName(name);
        if (menuName == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("요청하신" + name + " 가 존재하지 않습니다.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(menuName);
    }
}
