package com.example.demo.controller;
import com.example.demo.entity.Menu;
import com.example.demo.service.MenuService;
import lombok.extern.java.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/menus")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MenuController {

    @Autowired
    private MenuService service;

    @GetMapping("")
    public ResponseEntity<List<Menu>> list() throws Exception {

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

}
