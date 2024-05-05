package com.Ju00.todoList.controller;

import com.Ju00.todoList.dto.ResponseDTO;
import com.Ju00.todoList.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test") //(GET) http://localhost:8080/test
public class TestController {

    @GetMapping
    public String testController() {
        return "Hello World!";
    }

    @GetMapping("/testGetMapping")      //(GET) http://localhost:8080/test/testGetMapping
    public String testControllerWithPath() {
        return "Hello World! testGetMapping ";
    }

    @GetMapping("/{id}")
    public String testControllerWithPathVariables(@PathVariable(required = false) int id) {
        return "Hello World! ID " + id;
    }

    // /test경로는 이미 존재하므로 /test/testRequestParam으로 지정했다.
    @GetMapping("/testRequestParam")    //(GET) http://localhost:8080/test/testRequestParam?id=123
    public String testControllerRequestParam(@RequestParam(required = false) int id) {
        return "Hello World! ID " + id;
    }

    // /test경로는 이미 존재하므로 /test/testRequestBody로 지정했다.
    @GetMapping("/testRequestBody")     // @RequestBody ~ : RequestBody로 보내오는 JSON을 TestReqestBodyDTO 오브젝트로 변환
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
        return "Hello World! ID " + testRequestBodyDTO.getId() + " Message : " + testRequestBodyDTO.getMessage();
    }

    @GetMapping("/testResponseBody")    // ResponseDTO를 반환하는 컨트롤러
    //(GET) http://localhost:8080/test/testResponseBody
    public ResponseDTO<String> testControllerResponseBody() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseDTO");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return response;
    }

    @GetMapping("/testResponseEntity")  // ResponseEntity를 반환하는 컨트롤러
    //(GET) http://localhost:8080/test/testResponseEntity
    public ResponseEntity<?> testControllerResponseEntity() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseEntity. And you got 400!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        // http status를 400로 설정.
        return ResponseEntity.badRequest().body(response);
    }
}
