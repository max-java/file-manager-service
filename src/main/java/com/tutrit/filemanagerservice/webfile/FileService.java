package com.tutrit.filemanagerservice.webfile;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileService {

    private final FileMetaRepository fileMetaRepository;
    private final FileBytesRepository fileBytesRepository;

    public FileService(final FileMetaRepository fileMetaRepository, final FileBytesRepository fileBytesRepository) {
        this.fileMetaRepository = fileMetaRepository;
        this.fileBytesRepository = fileBytesRepository;
    }

    public String saveUploaded(MultipartFile file) throws IOException {
        FileMeta fileMeta = new FileMeta(file);
        fileMeta.setUuid(UUID.randomUUID());
        fileMeta = fileMetaRepository.save(fileMeta);
        FileBytes fileBytes = new FileBytes(file, fileMeta);
        fileBytesRepository.save(fileBytes);
        return fileMeta.getUuid().toString();
    }

    public byte[] getFileBytesByUuid(UUID uuid) {
        Optional<FileBytes> fileBytes = fileBytesRepository.findByUuid(uuid);
        if(fileBytes.isPresent()) {
            return fileBytes.get().getBytes();
        }
        else return new byte[0];
    }
}
