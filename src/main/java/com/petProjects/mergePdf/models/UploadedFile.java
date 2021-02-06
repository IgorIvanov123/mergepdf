package com.petProjects.mergePdf.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "uploaded_files")
public class UploadedFile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;

    String name;
    String guid;
    Date uploadedAt;
    Date ttl;

    @ManyToOne
    UserSession userSession;

    @ManyToOne
    MergedFile mergedFile;

    public UploadedFile() {
    }

    public Long getId() {
        return this.Id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGuid() {
        return this.guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Date getUploadedAt() {
        return this.uploadedAt;
    }

    public void setUploadedAt(Date uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public Date getTtl() {
        return this.ttl;
    }

    public void setTtl(Date ttl) {
        this.ttl = ttl;
    }

    public UserSession getUserSession() {
        return this.userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    public MergedFile getMergedFile() {
        return this.mergedFile;
    }

    public void setMergedFile(MergedFile mergedFile) {
        this.mergedFile = mergedFile;
    }

}
