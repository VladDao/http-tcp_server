package com.plietnov.task.bean;

import com.plietnov.task.entity.Product;

import java.util.List;
import java.util.Optional;

public class Shop {

    private List<Product> productList;

    public Shop(List<Product> list) {
        this.productList = list;
    }

    public Product get(Integer id) {
        Optional product = Optional.of(productList.stream().filter(o -> o.getId() == id).findFirst()).get();
        if (product.isPresent()) {
            return (Product) product.get();
        }
        return null;
    }

    public void add(Product product) {
        productList.add(product);
    }

    public List<Product> getAll() {
        return productList;
    }
}
