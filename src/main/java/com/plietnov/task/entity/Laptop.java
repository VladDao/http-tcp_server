package com.plietnov.task.entity;

import com.plietnov.task.MyAnnotation;

import java.util.Objects;

public class Laptop extends Computer {

    private String description;

    public Laptop() {
    }

    public Laptop(int id, String nameOfProduct, String type, String classification, String description, int cost) {
        super(id, nameOfProduct, type, classification, cost);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @MyAnnotation(key = "product_description")
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (o.getClass() != this.getClass())) {
            return false;
        }
        Laptop laptop = (Laptop) o;
        return getDescription().equals(laptop.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription());
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "Id='" + getId() + '\'' +
                ", Type='" + getType() + '\'' +
                ", Class='" + getClassification() + '\'' +
                ", Description='" + description + '\'' +
                '}';
    }
}
