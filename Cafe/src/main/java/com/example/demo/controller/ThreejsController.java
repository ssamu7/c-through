package com.example.demo.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

@Log
@Controller
@CrossOrigin(origins = "http://localhost:3080", allowedHeaders = "*")
public class ThreejsController {
    @PostMapping("/three")
    public int[][] threeNum() throws Exception {
        return null;
    }
}
