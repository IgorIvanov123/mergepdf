package com.petProjects.mergePdf.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "merged_files")
public class MergedFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String guid;

    @ManyToOne
    UserSession userSession;

    public MergedFile() {
    }

    public Long getId() {
        return this.id;
    }

    public String getGuid() {
        return this.guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public UserSession getUserSession() {
        return this.userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

}
