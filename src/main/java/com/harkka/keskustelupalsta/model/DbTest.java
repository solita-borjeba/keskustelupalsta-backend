package com.harkka.keskustelupalsta.model;

import javax.persistence.*;

@Entity
@Table(name = "dbtest")
public class DbTest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "subject")
    private String subject;

    public DbTest() {

    }

    public DbTest (String subject) {
        this.subject = subject;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
