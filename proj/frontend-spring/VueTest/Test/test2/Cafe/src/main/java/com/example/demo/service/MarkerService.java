package com.example.demo.service;

import com.example.demo.entity.Marker;
import com.example.demo.repository.MarkerRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class MarkerService {
    @Autowired
    MarkerRepository repository;

    public void create (Marker marker) throws Exception {
        repository.create(marker);
    }

    public List<Marker> list (Marker marker) throws Exception {
        return repository.list(marker);
    }
}
