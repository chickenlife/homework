package com.study.homework.day2.service;

import com.study.homework.day2.dto.PersonGradeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;

@Service
@Slf4j
public class UserInfoService {

    PersonGradeDto personGradeDto = new PersonGradeDto();
    byte[] serializedUserInfo;

    @PostConstruct
    public void initialize() throws IOException {
        loadObject();
    }

    public String hello(){
        return "hello~";
    }

    public String addUserInfo(PersonGradeDto personGradeDto) throws IOException {
        log.debug("[service : registrationScore] userInfoDTO={}", personGradeDto);
        this.personGradeDto = personGradeDto;
        saveObject(personGradeDto); //@PreDestroy?
        return "Success, Add UserInfo.";
    }

    public PersonGradeDto selectUserInfo(){
        return personGradeDto;
    }

    public String deleteUserInfo(){
        personGradeDto.setUserName(null);
        personGradeDto.setAge(0);
        personGradeDto.setGrade(0);
        return "Success, Delete UserInfo.";
    }

    public void saveObject(PersonGradeDto personGradeDto) throws IOException {
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            try(ObjectOutputStream oos = new ObjectOutputStream(baos)){
                oos.writeObject(personGradeDto);
                serializedUserInfo = baos.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileOutputStream fos = new FileOutputStream("c:\\temp\\test.obj");
        fos.write(serializedUserInfo);
    }

    public void loadObject() throws IOException {
        try{
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
                    personGradeDto = (PersonGradeDto)objectUserInfo;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.debug("loaded UserInfoDTO is {}", personGradeDto);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String modifyUserInfo(PersonGradeDto personGradeDto) throws IOException {
        this.personGradeDto.setUserName(personGradeDto.getUserName());
        this.personGradeDto.setAge(personGradeDto.getAge());
        this.personGradeDto.setGrade(personGradeDto.getGrade());
        saveObject(this.personGradeDto);
        return "Success, modified UserInfo";
    }
}
