package com.study.homework.day3d.controller;

import com.study.homework.day3d.model.Tutorial;
import com.study.homework.day3d.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TutorialController {
    @Autowired
    TutorialRepository tutorialRepository;

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required=false) String title){
       try{
           List<Tutorial> tutorials = new ArrayList<Tutorial>();

           tutorialRepository.findAll().forEach(tutorials::add);

           if(tutorials.isEmpty()){
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(tutorials, HttpStatus.OK);
       }catch(Exception e){
           return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial){
        try{
            Tutorial tutorial1 = tutorialRepository.save(tutorial);
            return new ResponseEntity<>(tutorial, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

