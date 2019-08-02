package com.plietnov.task.entity;

import com.plietnov.task.MyAnnotation;

import java.util.Objects;

public class ElectricalAppliance extends Product {

    private String type;

    public ElectricalAppliance() {
    }

    public ElectricalAppliance(int id, String nameOfProduct, String type) {
        super(id, nameOfProduct);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @MyAnnotation(key = "product_type")
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (o.getClass() != this.getClass())) {
            return false;
        }
        ElectricalAppliance electricalAppliances = (ElectricalAppliance) o;
        return getType().equals(electricalAppliances.getType());
    }

    @Override
    public String toString() {
        return "ElectricalAppliance{" +
                "Id='" + getId() + '\'' +
                ", Type='" + type + '\'' +
                '}';
    }
}
