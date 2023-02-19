package com.tutrit.filemanagerservice.webfile;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileMetaRepository extends PagingAndSortingRepository<FileMeta, Long> {

}
