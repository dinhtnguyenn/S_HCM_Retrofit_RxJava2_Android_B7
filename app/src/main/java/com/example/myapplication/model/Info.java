package com.example.myapplication.model;

public class Info {
    private String course;
    private String place;
    private String website;
    private String fanpage;
    private String youtube;
    private String games;
    private String logo;

    public Info(String course, String place, String website, String fanpage, String youtube, String games, String logo) {
        this.course = course;
        this.place = place;
        this.website = website;
        this.fanpage = fanpage;
        this.youtube = youtube;
        this.games = games;
        this.logo = logo;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFanpage() {
        return fanpage;
    }

    public void setFanpage(String fanpage) {
        this.fanpage = fanpage;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
