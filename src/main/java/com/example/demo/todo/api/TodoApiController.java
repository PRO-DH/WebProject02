package com.example.demo.todo.api;

import com.example.demo.todo.dto.FindAllDTO;
import com.example.demo.todo.dto.TodoDto;
import com.example.demo.todo.entity.ToDo;
import com.example.demo.todo.repository.TodoRepository;
import com.example.demo.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoApiController {

    private final TodoService service;

    // 할 일 목록 전체조회 요청
    @GetMapping
    public ResponseEntity<?> todos() {
        log.info("/api/todos GET request!");
        return ResponseEntity.ok().body(service.findAllServ());
    }



    // 할 일 목록 등록 요청
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ToDo newTodo) {
        // Rest Controller 의 반환값은 무조건 ResponseEntity<>로 해야 상태코드를 보낼 수 있다.

        newTodo.setUserId("noname");
        log.info("/api/todos POST request! - {}", newTodo);

        try {
            FindAllDTO dto = service.createServ(newTodo);
            if (dto == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }








    // 할 일 삭제 요청
    // URI : /api/todos/3 =? 3번 할 일 삭제 후 삭제된 이후 갱신된 할 일 목록 리턴
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        log.info("/api/todos/{} DELETE request!",id);
        try{
            FindAllDTO dtos = service.deleteServ(id);
            return ResponseEntity.ok().body(dtos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 할 일 개별 조회 요청
    // URI : /api/todos/3 => 3번 할 일 조회해서 클라이언트에게 리턴

    @GetMapping("{number}")
    public ResponseEntity<?> find(int number){
        log.info("/api/todos/%d Get REQUEST!",number);
        return ResponseEntity.ok().body(service.findOneServ(number));
    }

}