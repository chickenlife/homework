package com.study.homework.controller;

import com.study.homework.dto.UserInfoDTO;
import com.study.homework.service.UserInfoService;
import org.springframework.web.bind.annotation.*;

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
    public String registrationScore(@RequestBody UserInfoDTO userInfoDTO) throws IOException {
        return userInfoService.registrationScore(userInfoDTO);
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
