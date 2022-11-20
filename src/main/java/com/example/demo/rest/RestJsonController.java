package com.example.demo.rest;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/json")
public class RestJsonController {
    /**
     * 로그 레벨
     * trace - 잡다한 내용을 로깅
     * debug - 개발 당시 확인할 내용들 로깅
     * info  - 운영 시 필요한 정보들을 로깅
     * warn  - 에러까지는 아니지만 경고상황 로깅
     * error - 심각한 에러 로깅
     */
    @PostMapping("/major")
    public List<String> major() {
        System.out.println("/json/major POST request!");
        return null;
    }

}