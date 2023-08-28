package com.example.childhealthrecord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource("classpath:db-postgres.properties")
public class ChildHealthRecordApplication {

    public static void main(String[] args) {

        SpringApplication.run(ChildHealthRecordApplication.class, args);
    }

}
