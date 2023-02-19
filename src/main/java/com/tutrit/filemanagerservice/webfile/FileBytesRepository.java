package com.tutrit.filemanagerservice.webfile;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FileBytesRepository extends PagingAndSortingRepository<FileBytes, Long> {
    Optional<FileBytes> findByUuid(UUID uuid);

}
