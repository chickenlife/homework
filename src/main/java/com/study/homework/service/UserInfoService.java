package com.study.homework.service;

import com.study.homework.dto.UserInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.Base64;

@Service
@Slf4j
public class UserInfoService {

    UserInfoDTO userInfoDTO = new UserInfoDTO();
    byte[] serializedUserInfo;

    @PostConstruct
    public void initialize() throws IOException {
        loadFile();
    }
    public String hello(){
        return "hello~";
    }

    public UserInfoDTO registrationScore(String userName, int age, int score) throws IOException {
        userInfoDTO.setUserName(userName);
        userInfoDTO.setAge(age);
        userInfoDTO.setScore(score);

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            try(ObjectOutputStream oos = new ObjectOutputStream(baos)){
                oos.writeObject(userInfoDTO);
                serializedUserInfo = baos.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveFile(serializedUserInfo);
        log.debug("serialized UserInfo : {}",Base64.getEncoder().encodeToString(serializedUserInfo));

        return userInfoDTO;
    }

    public UserInfoDTO selectUserInfo(){
        return userInfoDTO;
    }

    public void deleteUserInfo(){
        userInfoDTO.setUserName(null);
        userInfoDTO.setAge(0);
        userInfoDTO.setScore(0);
    }

    public void saveFile(byte[] inputString) throws IOException {
        FileOutputStream fos = new FileOutputStream("c:\\temp\\test.obj");
        fos.write(inputString);
    }

    public void loadFile() throws IOException {
        FileInputStream fis = new FileInputStream("c:\\temp\\test.obj");

        int readCount;
        byte[] buffer = new byte[1024];

        while((readCount = fis.read(buffer))!=-1){
            log.debug("read data[{}] is {}",readCount,buffer.toString());
        }

    }
}
