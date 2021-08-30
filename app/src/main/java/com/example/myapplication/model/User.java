package com.example.myapplication.model;

public class User {
    private String id;
    private String name;
    private String email;
    private String gender;
    private Contact contact;

    public User(String id, String name, String email, String gender, Contact contact) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
