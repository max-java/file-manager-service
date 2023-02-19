package com.tutrit.filemanagerservice.webfile;

import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@CrossOrigin
@RestController
public class FileController {

    private final FileService fileService;

    public FileController(final FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/files")
    public String uploadFile(@RequestParam MultipartFile multipartFile) throws IOException {
        return fileService.saveUploaded(multipartFile);
    }

    @Transactional
    @GetMapping(value = "/files/{uuid}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] downloadFile(@PathVariable String uuid) {
        try {
            return fileService.getFileBytesByUuid(UUID.fromString(uuid));
        } catch (Exception e) {
            return new byte[0];
        }
    }
}
