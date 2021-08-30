package com.example.myapplication.model;

public class Product {
    private int No;
    private String ProductName;
    private String Price;

    public Product(int no, String productName, String price) {
        No = no;
        ProductName = productName;
        Price = price;
    }

    public Product(String productName, String price) {
        ProductName = productName;
        Price = price;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
