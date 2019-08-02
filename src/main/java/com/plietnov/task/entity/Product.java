package com.plietnov.task.entity;

import com.plietnov.task.MyAnnotation;

import java.io.Serializable;

public abstract class Product implements Serializable {

    private int id;
    private String nameOfProduct;

    public Product() {
    }

    public Product(int id, String nameOfProduct) {
        this.id = id;
        this.nameOfProduct = nameOfProduct;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    @MyAnnotation(key = "product_name")
    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public int getId() {
        return id;
    }

    @MyAnnotation(key = "product_id")
    public void setId(int id) {
        this.id = id;
    }
}
