package com.naver.ehd9567.hollys_backend.controller;


import com.naver.ehd9567.hollys_backend.dao.HollysDAO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hollys")
public class HollysController {

    @Autowired
    HollysDAO hollysDAO;

    @Operation(summary = "Hollys 메인 화면.",
        description = "Hollys의 메인 화면."
    )
    @GetMapping
    public String helloHollys() {
        return "index.html";
    }

}
