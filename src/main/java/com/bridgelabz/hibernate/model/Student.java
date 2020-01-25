package com.bridgelabz.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
public class Student {

    @Id
    private int rollNo;

    private int marks;
    private String name;

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("rollNo=" + rollNo)
                .add("marks=" + marks)
                .add("name='" + name + "'")
                .toString();
    }
    //    @OneToOne
//    private Laptop laptop;

   /* public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }*/
//    @OneToMany(mappedBy = "student")
//   private List<Laptop> laptops = new ArrayList<Laptop>();
//
//    public List<Laptop> getLaptops() {
//        return laptops;
//    }

//    public void setLaptops(List<Laptop> laptops) {
//        this.laptops = laptops;
//    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
