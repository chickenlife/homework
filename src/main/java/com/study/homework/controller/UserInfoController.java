package com.study.homework.controller;

import com.study.homework.dto.UserInfoDTO;
import com.study.homework.service.UserInfoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class UserInfoController {

    final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("/hello")
    public String hello(){
        return userInfoService.hello();
    }

    @GetMapping("/score")
    public UserInfoDTO registrationScore(String userName, int age, int score) throws IOException {
        return userInfoService.registrationScore(userName, age, score);
    }

    @PostMapping("/score")
    public UserInfoDTO selectUserInfo(){
        return userInfoService.selectUserInfo();
    }

    @DeleteMapping("/score")
    public void deleteUserInfo(){
        userInfoService.deleteUserInfo();
    }
}
