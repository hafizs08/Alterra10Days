package com.example.demo.service;

import com.example.demo.entity.LoggingMonggo;
import com.example.demo.repository.LoggingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class LoggingServiceImpl implements LoggingService {
    @Autowired
    private LoggingRepository loggingRepository;

    @Override
    public void createLog(HashMap<String, Object> data, String type) {
        LoggingMonggo log = new LoggingMonggo();
        log.setId(UUID.randomUUID().toString());
        log.setData(data);
        log.setType(type);
        loggingRepository.save(log);
    }
}
