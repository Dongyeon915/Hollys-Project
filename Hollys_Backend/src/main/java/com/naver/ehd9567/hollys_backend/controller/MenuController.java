package com.naver.ehd9567.hollys_backend.controller;

import com.naver.ehd9567.hollys_backend.dao.MenuDAO;
import com.naver.ehd9567.hollys_backend.dto.MenuDTO;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {

  @Autowired
  private MenuDAO menuDAO;

  @GetMapping
  public List<MenuDTO> getByAllMenu() {
    return menuDAO.getByAllMenu();
  }

  @GetMapping("/id{id}")
  public ResponseEntity<Object> getByMenuId(@PathVariable Integer id) {
    MenuDTO menuDTOId = menuDAO.getByMenuId(id);
    if (menuDTOId == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id확인 바람");
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(menuDTOId);
    }
  }

  @GetMapping("/name")
  public ResponseEntity<Object> getByMenuName(@RequestParam("name") String name) {
    MenuDTO menuName = menuDAO.getByMenuName(name);
    if (menuName == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("해당" + name + " 은 메뉴에 없습니다");
    }
    return ResponseEntity.status(HttpStatus.OK).body(menuName);
  }
}
