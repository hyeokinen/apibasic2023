package com.example.apibasic.req;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.templateparser.markup.HTMLTemplateParser;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller // 클라이언트가 보낸 요청을 받을 수 있음
@ResponseBody
@Slf4j // 로그 라이브러리
public class ApiController1 {

    // 요청을 받아서 처리할 메서드
    // request.getMethod가 실행되면 안에 중괄호로 들어감
    // print를 안쓰는 이유는 데이터 용량을 많이 차지하므로 비효율적이기 때문이다.
    @RequestMapping(value = "/hello", method = {GET, POST})
    public String hello(HttpServletRequest request) {

        log.trace("trace 로그~~~~~");
        log.debug("debug 로그~~~~~");
        log.info("hello~~~ spring! - {}", request.getMethod());
        log.warn("warn 로그~~~~~");
        log.error("error 로그~~~~~");
        return "";
    }

    // GET요청만 따로 처리하겠다
//    @RequestMapping(value = "/greet", method = GET)
    @GetMapping("/greet")
    public String greet() {
        log.info("/greet GET 요청!!");
        return "";
    }

    @PostMapping("/greet")
    public String greet2() {
        log.info("/greet POST 요청!!");
        return "";
    }

    // 요청 헤더 읽기
    @GetMapping("/header")
    public String header(HttpServletRequest request){
        String host = request.getHeader("Host");
        String accept = request.getHeader("Accept");
        String pet = request.getHeader("pet");

        log.info("=========== header info ===========");
        log.info(" # host : {}",host);
        log.info(" # accept : {}",accept);
        log.info(" # pet : {}",pet);

        return "";
    }


}
