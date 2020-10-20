package com.example.demo.controller;

import com.example.demo.entity.Marker;
import com.example.demo.service.MarkerService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/maker")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class MapController {

    @Autowired
    private MarkerService service;

    @PostMapping("/create")
    public void create(@Validated @RequestBody Marker marker) throws Exception {
        log.info("Controller Maker Create");
        service.create(marker);
    }

    @PostMapping("/list")
    public ResponseEntity<List<Marker>> register(@Validated @RequestBody Marker marker) throws Exception {
        log.info("Controller Maker List");
        service.create(marker);

        return new ResponseEntity<>(service.list(marker), HttpStatus.OK);
    }
}
