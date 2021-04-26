package com.study.homework.day3b.controller;

import com.study.homework.day3b.dto.BoardDTO;
import com.study.homework.day3b.dto.BoardListDTO;
import com.study.homework.day3b.service.BoardService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping
    public ResponseEntity<?> list(final BoardListDTO model){
        ResponseEntity<?> entity = null;
        try{
            entity = new ResponseEntity<BoardListDTO>(boardService.list(model), HttpStatus.OK);
        } catch (Exception e) {
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entity;
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> view(@PathVariable("id") final long id){
        ResponseEntity<?> entity = null;
        try{
            entity = new ResponseEntity<BoardDTO>(boardService.view(id), HttpStatus.OK);
        }catch(NotFoundException e){
            entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entity;
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody final BoardDTO model){
        ResponseEntity<?> entity = null;
        try{
            entity = new ResponseEntity<BoardDTO>(boardService.insert(model),HttpStatus.CREATED);
        }catch(Exception e){
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entity;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") final long id,
                                    @RequestBody final BoardDTO model) {
        ResponseEntity<?> entity = null;
        try{
            entity = new ResponseEntity<BoardDTO>(boardService.update(model,id),HttpStatus.OK);
        }catch(Exception e) {
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") final long id){
        ResponseEntity<?> entity = null;
        try{
            boardService.delete(id);
            entity = new ResponseEntity<>(HttpStatus.OK);
        }catch(NotFoundException e){
            entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entity;
    }
}

