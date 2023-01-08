package com.naver.ehd9567.hollys_backend.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hollys")
public class HollysController {

    @GetMapping
    public String helloHollys() {
        return "Hello, Hollys!";
    }
}
