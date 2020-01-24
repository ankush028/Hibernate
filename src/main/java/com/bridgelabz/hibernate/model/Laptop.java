package com.bridgelabz.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {

    @Id
    private int lapid;

    private String lapName;
    @ManyToOne
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public int getLapid() {
        return lapid;
    }

    public void setLapid(int lapid) {
        this.lapid = lapid;
    }

    public String getLapName() {
        return lapName;
    }

    public void setLapName(String lapName) {
        this.lapName = lapName;
    }
}
