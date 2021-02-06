package com.petProjects.mergePdf.repositories;

import com.petProjects.mergePdf.models.UploadedFile;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadedFileRepository extends CrudRepository<UploadedFile, Long>{
    
}
