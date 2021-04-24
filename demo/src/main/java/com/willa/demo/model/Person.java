package com.willa.demo.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@Data
public class Person {
    private final UUID id;
    private final String name;

//    public Person(UUID id, String name) {
//        this.id = id;
//        this.name = name;
//    }
}
