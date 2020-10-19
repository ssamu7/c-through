package com.example.demo.controller;

import com.example.demo.nativeinterface.array.ArrayReturnTest;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log
@Controller
@CrossOrigin(origins = "http://localhost:3080", allowedHeaders = "*")
public class ThreejsController {
    static final Logger log = LoggerFactory.getLogger(ThreejsController.class);

    float[] dist = new float[1024];
    float[] angle = new float[1024];

    @PostMapping("/three")
    public int[][] threeNum() throws Exception {
        return null;
    }

    @GetMapping("/setlidartest")
    public String setlidartest() throws InterruptedException {
        log.info("setlidartest");

        ArrayReturnTest.readyToGetFloatArray();

        return "lidar";
    }

    @GetMapping("/lidartest")
    public String lidartest() throws InterruptedException {
        log.info("lidartest");

        // JVM Stack Frame의 한계로 일정 범위 이상은 Stack이 박살나는 현상을 초래함
        // 좀 더 크게 잡아야 한 번에 데이터를 많이 땡겨올 수 있는데 반복적으로 JNI API를 호출시켜야함
        ArrayReturnTest.getFloatArray(dist, angle);

        //Thread.sleep(1000);
        for (int i = 0; i < dist.length; i++) {
            log.info("dist = " + dist[i] + ", angle = " + angle[i]);
        }

        return "lidar";
    }
}
