package com.nobrand.jpa.mysql.standalone.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MEMBER",
       uniqueConstraints = {
        @UniqueConstraint(name = "NAME_AGE_UNIQUE", columnNames = {"NAME", "AGE"})
       })
public class Member {

    /*
    * Entity's default constructor is mandatory.
    * Set visibility to protected, not to be used by others.
    * */
    protected Member() { }

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String username;

    @Column(name = "AGE")
    private int age;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME")
    private Date createdTime;

    @Column(name = "MODIFIED_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
