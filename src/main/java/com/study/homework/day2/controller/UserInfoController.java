package com.study.homework.day2.controller;

import com.study.homework.day2.dto.PersonGradeDto;
import com.study.homework.day2.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@Slf4j
public class UserInfoController {

    final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("/hello")
    public String hello(){
        return userInfoService.hello();
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
