package com.naver.ehd9567.hollys_backend.controller;

import com.naver.ehd9567.hollys_backend.dao.MenuDAO;
import com.naver.ehd9567.hollys_backend.dto.MenuDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
