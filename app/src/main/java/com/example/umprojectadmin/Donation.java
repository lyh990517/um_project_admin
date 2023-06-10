package com.example.umprojectadmin;

import java.io.Serializable;

public class Donation implements Serializable {
    private String name;
    private int age;
    private String adress;
    private String grade;
    private String unbrellaNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getUnbrellaNum() {
        return unbrellaNum;
    }

    public void setUnbrellaNum(String unbrellaNum) {
        this.unbrellaNum = unbrellaNum;
    }
}
