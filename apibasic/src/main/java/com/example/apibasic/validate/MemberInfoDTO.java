package com.example.apibasic.validate;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MemberInfoDTO {

    @NotBlank @Email
    private String email;
    private String userName;
    @NotBlank @Size(min = 2, max =5)
    private String password;
    @JsonFormat(pattern = "yyMMdd")
    @Past // 과거 날짜인지 검사
    private LocalDate birthofDate;

    @Valid // 컴포지션 객체 입력값 검증
    private Address address; // 주소 정보
    @Valid
    private Card card; // 결제 카드 정보
}
