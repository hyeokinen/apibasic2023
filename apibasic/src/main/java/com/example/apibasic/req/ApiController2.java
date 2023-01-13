package com.example.apibasic.req;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@Slf4j
public class ApiController2 {

    // 요청 파라미터 읽기
    @GetMapping("/param1")
    public String param1(
            // 파라미터 키값과 변수명이 같으면 아노테이션 생략 가능
            // 즉 String username으로만 작성해도 아래 코드와 동일하다.
            // 서버에서 보내는 userAge와 클라이언트가 하는 age와 이름이 동일 하지 않으므로 생략 불가능
            String username
            , @RequestParam("age") int userAge
    ) {
        log.info("/param1?username={}&age={} GET!! ", username, userAge);
        log.info("내 이름은 {} 이고, 나이는 {} 세다!!", username, userAge);
        return "";
    }

    @GetMapping("/param2")
    public String param2(OrderInfo orderInfo) {
        log.info("/param2?orderNo={}&goodsName={}&goodsAmount={}"
                , orderInfo.getOrderNo()
                , orderInfo.getGoodsName()
                , orderInfo.getGoodsAmount());
        return "";
    }

    // 요청 바디 읽기 @ReuestBody
    // 요청사항이 헤더에 안들어오고 바디에 들어올 경우
    @PostMapping("/req-body")
    public String reqBody(@RequestBody OrderInfo orderInfo) {
        log.info("========= 주문 정보 ==========");
        log.info("# 주문번호: {}", orderInfo.getOrderNo());
        log.info("# 상품명: {}", orderInfo.getGoodsName());
        log.info("# 수량: {}", orderInfo.getGoodsAmount());
        return "";
    }




    // 커맨드 객체 : 클라이언트가 보낸 파라미터 이름과 필드명이 대소문자 포함 정확히 일치해야함
    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class OrderInfo {
        private Long orderNo;
        private String goodsName;
        private int goodsAmount;
    }

}
