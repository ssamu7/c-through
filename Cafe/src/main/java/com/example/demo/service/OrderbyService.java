package com.example.demo.service;

import com.example.demo.entity.Marker;
import com.example.demo.entity.Orderby;
import com.example.demo.repository.MarkerRepository;
import com.example.demo.repository.OrderbyRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class OrderbyService {
    @Autowired
    OrderbyRepository repository;

    public void create (Orderby orderby) throws Exception {
        repository.create(orderby);
    }

    public List<Orderby> list (String place) throws Exception {
        log.info("Service Orederby List");
        log.info(place);
        return repository.list(place);
    }
}
