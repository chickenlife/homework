package com.study.homework.day2.controller;

import com.study.homework.day2.dto.PersonGradeDto;
import com.study.homework.day2.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class UserInfoController {

    final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("/hello")
    public Map<String, String> hello(){
        return userInfoService.hello();
    }
    @GetMapping("/hello1")
    public String hello1(){
        return userInfoService.hello1();
    }
    @GetMapping("/hello2")
    public List<String> hello2(){
        return userInfoService.hello2();
    }
    @GetMapping("/hello3")
    public Integer hello3(){
        return 1;
    }
    @GetMapping("/hello4")
    public String hello4(){
        return "/test.html";
    }


    @PostMapping("/grade")
    public String addUserInfo(@RequestBody PersonGradeDto personGradeDto) throws IOException {
        log.debug("[registrationScore] userInfoDTO={}", personGradeDto);
        return userInfoService.addUserInfo(personGradeDto);
    }

    @GetMapping("/grade")
    public PersonGradeDto selectUserInfo(){
        return userInfoService.selectUserInfo();
    }

    @PostMapping("/delete-grade")
    public String deleteUserInfo() {
        return userInfoService.deleteUserInfo();
    }

    @PostMapping("/modify-grade")
    public String modifyUserInfo(@RequestBody PersonGradeDto personGradeDto) throws IOException {
        return userInfoService.modifyUserInfo(personGradeDto);
    }
}
