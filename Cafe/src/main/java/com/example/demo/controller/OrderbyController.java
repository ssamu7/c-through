package com.example.demo.controller;

import com.example.demo.entity.Orderby;
import com.example.demo.service.OrderbyService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Log
@RestController
@RequestMapping("/orderby")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class OrderbyController {

    @Autowired
    private OrderbyService service;

    @PostMapping("/create")
    public void create(@Validated @RequestBody Orderby orderby) throws Exception {
        log.info("Controller Orderby Create");
        service.create(orderby);
    }

    @PostMapping("/list")
    public ResponseEntity<List<Orderby>> orderlsit(@Validated @RequestBody HashMap<String, String> values) throws Exception {
        String place = values.get("place");

        log.info("Controller Orderby Order List");
        log.info(place);
        return new ResponseEntity<>(service.list(place), HttpStatus.OK);
    }
}
