package com.example.visual_lab7;

public class PartDescription {
    private Integer id;
    private Integer year;
    private String make;
    private String model;
    private String cat;
    private String name;
    private Double price;

    public PartDescription(Integer id, Integer year, String make, String model, String cat, String name, Double price) {
        this.id = id;
        this.year = year;
        this.make = make;
        this.model = model;
        this.cat = cat;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PartDescription{" +
                "id=" + id +
                ", year=" + year +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", cat='" + cat + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
