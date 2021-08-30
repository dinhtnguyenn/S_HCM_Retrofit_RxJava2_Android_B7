package com.example.myapplication.model;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;

    public UserList(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUserList() {
        return users;
    }

    public void setUserList(ArrayList<User> users) {
        this.users = users;
    }
}
