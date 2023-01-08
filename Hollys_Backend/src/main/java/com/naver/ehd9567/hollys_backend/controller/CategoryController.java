package com.naver.ehd9567.hollys_backend.controller;

import com.naver.ehd9567.hollys_backend.dao.CategoryDAO;
import com.naver.ehd9567.hollys_backend.dto.CategoryDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

  @Autowired
  private CategoryDAO categoryDAO;

  @GetMapping("/allcategory")
  public List getAllCategory(){
    return categoryDAO.getAllCategory();
  }


}
