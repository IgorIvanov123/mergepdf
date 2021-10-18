package com.petProjects.mergePdf.repositories;

import com.petProjects.mergePdf.models.UserSession;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionRepository extends CrudRepository<UserSession, Long> {
    
    public UserSession findByToken(String token);
}
