package com.pbb.microserviceprovideruser.DO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Student implements Serializable {
    private static final long serialVersionUID = 8806002428681476396L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stuno;

    @Column
    private String stuname;

    @Column
    private String sex;

    @Column
    private Integer age;

    @Column
    private String departno;

    @Column
    private String classno;

    @Column
    private Date regdate;


    public Long getStuno() {
        return stuno;
    }

    public void setStuno(Long stuno) {
        this.stuno = stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartno() {
        return departno;
    }

    public void setDepartno(String departno) {
        this.departno = departno;
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
}
