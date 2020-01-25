
package com.bridgelabz.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.StringJoiner;

@Entity
    public class Laptop {

    @Id
    private int lapid;
    private int price;
    private String lapBrand;

    @Override
    public String toString() {
        return new StringJoiner(", ", Laptop.class.getSimpleName() + "[", "]")
                .add("lapid=" + lapid)
                .add("price=" + price)
                .add("lapBrand='" + lapBrand + "'")
                .toString();
    }

    public int getLapid() {
        return lapid;
    }

    public void setLapid(int lapid) {
        this.lapid = lapid;
    }


    public String getLapBrand() {
        return lapBrand;
    }

    public void setLapBrand(String lapBrand) {
        this.lapBrand = lapBrand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


//    @ManyToOne
//    private Student student;

//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }

}

