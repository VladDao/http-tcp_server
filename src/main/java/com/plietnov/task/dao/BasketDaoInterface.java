package com.plietnov.task.dao;

import com.plietnov.task.bean.Basket;

import java.util.Optional;

public interface BasketDaoInterface {

    Optional<Integer> get(int id);

    Basket getAll();

    boolean isEmpty();

    void add(int id, int amount);

    Basket copy();

    void clear();
}
