package com.tutrit.filemanagerservice.webfile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import java.io.IOException;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileBytes {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    private UUID uuid;
    @Lob
    private byte[] bytes;

    public FileBytes(MultipartFile uploadedFile, FileMeta file) throws IOException {
        this.uuid = file.getUuid();
        this.bytes = uploadedFile.getBytes();
    }
}
