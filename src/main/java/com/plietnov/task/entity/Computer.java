package com.plietnov.task.entity;

import com.plietnov.task.MyAnnotation;
import com.plietnov.task.entity.intef.ComputerInterface;

import java.util.Objects;

public class Computer extends ElectricalAppliance implements ComputerInterface {

    private String classification;
    private int cost;

    public Computer() {
    }

    public Computer(int id, String nameOfProduct, String type, String classification, int cost) {
        super(id, nameOfProduct, type);
        this.classification = classification;
        this.cost = cost;
    }

    @MyAnnotation(key = "product_cost")
    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getClassification() {
        return classification;
    }

    @MyAnnotation(key = "product_class")
    public void setClassification(String classification) {
        this.classification = classification;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getClassification());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (o.getClass() != this.getClass())) {
            return false;
        }
        Computer computer = (Computer) o;
        return getClassification().equals(computer.getClassification());
    }

    @Override
    public String toString() {
        return "Computer{" +
                "Id='" + getId() + '\'' +
                ", Name='" + getNameOfProduct() + '\'' +
                ", Type='" + getType() + '\'' +
                ", classification='" + classification + '\'' +
                '}';
    }
}
