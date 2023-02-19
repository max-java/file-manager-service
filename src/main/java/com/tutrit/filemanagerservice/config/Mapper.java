package com.tutrit.filemanagerservice.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileDescriptor;

@Configuration
public class Mapper {

    @Bean
    public ObjectMapper objectMapper() {
        var objectMapper = new ObjectMapper();
//        objectMapper
//                .configOverride(FileDescriptor.class)
//                .setIsIgnoredType(true);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.getDeserializationConfig();
        return objectMapper;
    }
}
