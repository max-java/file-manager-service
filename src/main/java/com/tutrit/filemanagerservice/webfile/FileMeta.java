package com.tutrit.filemanagerservice.webfile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileMeta {

    @javax.persistence.Id // TODO: 1/23/23 replace with UUID
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    private UUID uuid;
    private String name;
    private String nameWithExtension;
    private String description;
    private String extension;
    private String contentType;
    private Long size;


    public FileMeta(MultipartFile file) {
        this.contentType = file.getContentType();
        this.extension = FilenameUtils.getExtension(file.getOriginalFilename());
        this.name = FilenameUtils.getBaseName(file.getOriginalFilename());
        this.size = file.getSize();
        this.nameWithExtension = FilenameUtils.getName(file.getOriginalFilename());
    }
}
