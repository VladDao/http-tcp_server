package com.plietnov.task.service;

import com.plietnov.task.bean.Basket;

public interface BasketServiceInterface {

    void addProduct(int id);

    Basket getBasket();

    void clearBasket();

    boolean isEmpty();
}
