package com.petProjects.mergePdf.repositories;

import com.petProjects.mergePdf.models.MergedFile;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MergedFileRepository extends CrudRepository<MergedFile, Long>{
    
}
