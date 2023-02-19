package com.tutrit.filemanagerservice.web;

import lombok.val;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

@Controller
public class FileUploadWebController {

    @GetMapping("/")
    public ModelAndView openFileUploadingPage() {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("index");
        return mov;
    }

    @PostMapping("/")
    public String uploadFile(@RequestParam MultipartFile uploadedFile) throws IOException {
        System.out.println(uploadedFile);
        return "redirect:/";
    }
}
