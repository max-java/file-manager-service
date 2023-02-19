package com.tutrit.filemanagerservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.FileDescriptor;

@EnableSwagger2
@SpringBootApplication
public class FileManagerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileManagerServiceApplication.class, args);
    }



}
