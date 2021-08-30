package com.example.myapplication.model;

public class Language {
    private InfoProject en;
    private InfoProject vn;

    public Language(InfoProject en, InfoProject vn) {
        this.en = en;
        this.vn = vn;
    }

    public InfoProject getEn() {
        return en;
    }

    public void setEn(InfoProject en) {
        this.en = en;
    }

    public InfoProject getVn() {
        return vn;
    }

    public void setVn(InfoProject vn) {
        this.vn = vn;
    }
}
