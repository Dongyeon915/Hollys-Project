package com.naver.ehd9567.hollys_backend.controller;

import com.naver.ehd9567.hollys_backend.dao.MenuDAO;
import com.naver.ehd9567.hollys_backend.dto.MenuDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
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
            @ApiResponse(responseCode = "200", description = "[성공] 모든 메뉴를 반환합니다.", content = @Content(mediaType = "application/json"))
        }
    )
    @GetMapping
    public List<MenuDTO> getByAllMenu() {
        return menuDAO.getByAllMenu();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getByMenuId(@PathVariable Integer id) {
        MenuDTO menuDTOId = menuDAO.getByMenuId(id);
        if (menuDTOId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id확인 바람");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(menuDTOId);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getByMenuName(@PathVariable("name") String name) {
        MenuDTO menuName = menuDAO.getByMenuName(name);
        if (menuName == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("해당" + name + " 은 메뉴에 없습니다");
        }
        return ResponseEntity.status(HttpStatus.OK).body(menuName);
    }
}
