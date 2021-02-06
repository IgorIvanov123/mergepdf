package com.petProjects.mergePdf.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user_session")
public class UserSession {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String token;

    @OneToMany(mappedBy = "userSession")
    @JsonIgnoreProperties("userSession")
    Set<UploadedFile> uploadedFiles = new HashSet<>();

    @OneToMany(mappedBy = "userSession")
    @JsonIgnoreProperties("userSession")
    Set<MergedFile> mergedFiles = new HashSet<>();

    public UserSession() {
    }

    public Long getId() {
        return this.id;
    }

    public Set<UploadedFile> getUploadedFiles() {
        return this.uploadedFiles;
    }

    public Set<MergedFile> getMergedFiles() {
        return this.mergedFiles;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
