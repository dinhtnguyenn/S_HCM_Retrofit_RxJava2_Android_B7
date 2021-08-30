package com.example.myapplication.model;

public class InfoCourse {
    private String course;
    private String link;
    private String image;

    public InfoCourse(String course, String link, String image) {
        this.course = course;
        this.link = link;
        this.image = image;
    }

    public InfoCourse(String course, String link) {
        this.course = course;
        this.link = link;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
