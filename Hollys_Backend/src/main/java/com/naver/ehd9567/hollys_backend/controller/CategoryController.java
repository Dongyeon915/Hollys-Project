package com.naver.ehd9567.hollys_backend.controller;

import com.naver.ehd9567.hollys_backend.dao.CategoryDAO;
import com.naver.ehd9567.hollys_backend.dto.CategoryDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryDAO categoryDAO;

    //모든걸 조회시 리스트로 받아야 검색이 가능하다
    @GetMapping("/allcategory")
    public List getAllCategory() {
        return categoryDAO.getAllCategory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        CategoryDTO categoryDAOById = categoryDAO.getById(id);
        if (categoryDAOById == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("들어온 값이 없습니다");
        }
        return ResponseEntity.status(HttpStatus.OK).body(categoryDAOById);
    }
    
    @GetMapping("/menu_fk/{menu_fk}")
    public ResponseEntity<Object> getByMenu_fk(@PathVariable Integer menu_fk) {
        List<CategoryDTO> menuFk = categoryDAO.getByMenu_fk(menu_fk);
        if (menuFk.size() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("값이 없습니다");
        }
        return ResponseEntity.status(HttpStatus.OK).body(menuFk);
    }

    //@RequestParam 사용한 Type 찾기
    @GetMapping("/type")
    public ResponseEntity<Object> getByType(@RequestParam("type") String type) {
        CategoryDTO categoryDTO = categoryDAO.getByType(type);
        return ResponseEntity.status(HttpStatus.OK).body(categoryDTO);
    }

    @PostMapping("/setCategory")
    public ResponseEntity<Object> setCategory(@RequestBody CategoryDTO setDTO) {
        int result = categoryDAO.setCategory(setDTO);
        if (result != 1) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("구성을 다시 확인 후 추가해주세요");
        }
        return ResponseEntity.status(HttpStatus.OK).body(setDTO);
    }
}
