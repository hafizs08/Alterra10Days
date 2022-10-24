package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.HashMap;

@Data
@NoArgsConstructor
@Document("logging")
public class LoggingMonggo {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private HashMap<String, Object> data;

    private String type;
}
