package com.stackroute.Soulmate.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Soulmate {

    @Id
    private int id;
    private String name;
    private String gender;
    private int age;

    public Soulmate() {
    }

    public Soulmate(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
