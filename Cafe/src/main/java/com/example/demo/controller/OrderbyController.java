package com.example.demo.controller;

import com.example.demo.entity.Orderby;
import com.example.demo.service.OrderbyService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/orderby")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class OrderbyController {

    @Autowired
    private OrderbyService service;

    @PostMapping("/create")
    public void create(@Validated @RequestBody Orderby orderby) throws Exception {
        log.info("Controller Orderby Create");
        service.create(orderby);
    }

    @PostMapping("/list")
    public ResponseEntity<List<Orderby>> orderlsit(@Validated @RequestBody String place) throws Exception {
        log.info("Controller Orderby Order List");
        return new ResponseEntity<>(service.list(place), HttpStatus.OK);
    }
}
