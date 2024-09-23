package com.example.myapplication.model;

public class Meat {
    private String meat_name;
    private String meat_type;
    private String meat_origin;
    private String meat_image;
    private double meat_price; // เพิ่มราคา

    // Getters and Setters
    public String getMeat_name() {
        return meat_name;
    }

    public void setMeat_name(String meat_name) {
        this.meat_name = meat_name;
    }

    public String getMeat_type() {
        return meat_type;
    }

    public void setMeat_type(String meat_type) {
        this.meat_type = meat_type;
    }

    public String getMeat_origin() {
        return meat_origin;
    }

    public void setMeat_origin(String meat_origin) {
        this.meat_origin = meat_origin;
    }

    public String getMeat_image() {
        return meat_image;
    }

    public void setMeat_image(String meat_image) {
        this.meat_image = meat_image;
    }

    public double getMeat_price() {
        return meat_price; // Getter สำหรับราคา
    }

    public void setMeat_price(double meat_price) {
        this.meat_price = meat_price; // Setter สำหรับราคา
    }
}
