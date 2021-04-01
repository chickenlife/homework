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
        loadObject();
    }

    public String hello(){
        return "hello~";
    }

    public String registrationScore(UserInfoDTO userInfoDTO) throws IOException {
        saveObject(); //@PreDestroy?
        return "result";
    }

    public UserInfoDTO selectUserInfo(){
        return userInfoDTO;
    }

    public void deleteUserInfo(){
        userInfoDTO.setUserName(null);
        userInfoDTO.setAge(0);
        userInfoDTO.setScore(0);
    }

    public void saveObject() throws IOException {
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            try(ObjectOutputStream oos = new ObjectOutputStream(baos)){
                oos.writeObject(userInfoDTO);
                serializedUserInfo = baos.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileOutputStream fos = new FileOutputStream("c:\\temp\\test.obj");
        fos.write(serializedUserInfo);
    }

    public void loadObject() throws IOException {
        FileInputStream fis = new FileInputStream("c:\\temp\\test.obj");

        int readCount;
        byte[] buffer = new byte[1024];

        while((readCount = fis.read(buffer))!=-1){
            log.debug("read data[{}] is {}",readCount,buffer.toString());
        }

        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            try {
                ObjectInputStream ois = new ObjectInputStream(bais);
                Object objectUserInfo = ois.readObject();
                userInfoDTO = (UserInfoDTO)objectUserInfo;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.debug("loaded UserInfoDTO is {}",userInfoDTO);
    }
}
