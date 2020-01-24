package com.bridgelabz.hibernate.model;


import javax.persistence.*;

//POJO Class
@Entity
//@Table(name = "bridgelabzEmployee")
public class Alien {

    @Id
    private int aid;
    //  @Transient         //Used to store Temporary Data
    private FullName name;
   // @Column(name ="Role")
    private String role;

    @Override
    public String toString() {
        return "Alien[aid="+aid+", name="+name+" color="+role+"]";
    }
    public FullName getName() {
        return name;
    }

    public void setName(FullName name) {
        this.name = name;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
