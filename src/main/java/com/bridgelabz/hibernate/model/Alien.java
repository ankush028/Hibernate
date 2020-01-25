package com.bridgelabz.hibernate.model;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

//POJO Class
//@Table(name = "bridgelabzEmployee")
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Alien {

    @Id
    private int aid;
    //  @Transient         //Used to store Temporary Data
//    private FullName name;
  //  @Column(name ="Role")
    private String color;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Alien[aid="+aid+", name="+name+" color="+color+"]";
    }
//    public FullName getName() {
//        return name;
//    }
//
//    public void setName(FullName name) {
//        this.name = name;
//    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
