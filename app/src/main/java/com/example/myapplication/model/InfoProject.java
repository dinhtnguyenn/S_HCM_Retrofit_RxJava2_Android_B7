package com.example.myapplication.model;

public class InfoProject {
    private String name;
    private String place;
    private String course1;
    private String course2;
    private String course3;

    public InfoProject(String name, String place, String course1, String course2, String course3) {
        this.name = name;
        this.place = place;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCourse1() {
        return course1;
    }

    public void setCourse1(String course1) {
        this.course1 = course1;
    }

    public String getCourse2() {
        return course2;
    }

    public void setCourse2(String course2) {
        this.course2 = course2;
    }

    public String getCourse3() {
        return course3;
    }

    public void setCourse3(String course3) {
        this.course3 = course3;
    }
}
