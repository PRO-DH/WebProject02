package com.example.demo.rest;


import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/json")
@Slf4j // 로깅라이브러리
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
    public List<String> major(@RequestBody List<String> majorList) {
        log.info("/json/major POST request! - {}", majorList);
        return null;
    }

    @PutMapping("/bbs")
    public void bbs(@RequestBody Article article){
        log.info("/json/bbs PUT request! - {}", article);
    }

    @DeleteMapping("/bbs-list")
    public void bbsList(@RequestBody List<Article> list) {
        log.info("/json/bbs-list DELETE request! - {}", list);
    }

    @Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
    public static class Article{

        private long id;
        private String title;
        private String content;
        private String writer;
    }

}