package com.plietnov.task.dao;

import com.plietnov.task.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ShopDaoInterface {

    Optional<Product> get(int id);

    List<Product> getAll();

    void showAll();
}
