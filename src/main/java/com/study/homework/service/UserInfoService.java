package com.study.homework.service;

import com.study.homework.dto.UserInfoDTO;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    UserInfoDTO userInfoDTO = new UserInfoDTO();

    public String hello(){
        return "hello~";
    }

    public UserInfoDTO registrationScore(String userName, int age, int score){
        userInfoDTO.setUserName(userName);
        userInfoDTO.setAge(age);
        userInfoDTO.setScore(score);
        return userInfoDTO;
    }

    public UserInfoDTO selectUserInfo(){
        return userInfoDTO;
    }

    public void deleteUserInfo(){
        userInfoDTO.setUserName("");
        userInfoDTO.setAge(0);
        userInfoDTO.setScore(0);
    }
}
