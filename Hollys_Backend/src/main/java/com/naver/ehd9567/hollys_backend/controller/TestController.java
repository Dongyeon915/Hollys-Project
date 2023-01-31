package com.naver.ehd9567.hollys_backend.controller;

import com.naver.ehd9567.hollys_backend.dao.TestDAO;
import com.naver.ehd9567.hollys_backend.dto.TestDTO;
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
@RequestMapping("/tests")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestController {

    @Autowired
    private TestDAO testDAO;

    @GetMapping("/alltest")
    public List<TestDTO> getTest() {
        return testDAO.getTest();
    }

    @PostMapping("/settest")
    public int setTest(@RequestBody TestDTO testDTO) {
        return testDAO.setTest(testDTO);
    }


    @PutMapping("/put")
    public ResponseEntity<Object> putTest(@RequestBody TestDTO testDTO) {
        int putDto = testDAO.putTest(testDTO);
        if (putDto != 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("잘못된 수정값");
        }
        return ResponseEntity.status(HttpStatus.OK).body("수정완료");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTest(@PathVariable int id){
        int results = testDAO.deleteTest(id);
        if (results == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("삭제되지않았습니다");
        }
        return ResponseEntity.status(HttpStatus.OK).body("삭제되었습니다");
    }
}
