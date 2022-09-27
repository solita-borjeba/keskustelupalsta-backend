package com.harkka.keskustelupalsta.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "subject")
    private String subjectname;

    @Column(name = "message")
    private String message;

    @Column(name = "aikaleima")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date aikaleima;
    private int numberOfMessage;

    public int getNumberOfMessage() {
        return numberOfMessage;
    }

    public void setNumberOfMessage(int numberOfMessage) {
        this.numberOfMessage = numberOfMessage;
    }

    public Subject() {
    }

    public Subject(String subjectname, String message) {
    //turha    this.id = 1;
        this.subjectname = subjectname;
        this.message = message;
        this.aikaleima = new Date();
        this.numberOfMessage = 99;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public Date getAikaleima() {
        return aikaleima;
    }

    public void setAikaleima(Date aikaleima) {
        this.aikaleima = aikaleima;
    }
}
