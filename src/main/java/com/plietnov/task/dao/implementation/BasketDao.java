package com.plietnov.task.dao.implementation;

import com.plietnov.task.bean.Basket;
import com.plietnov.task.dao.BasketDaoInterface;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class BasketDao implements BasketDaoInterface {

    private Basket basket;

    public BasketDao(Basket basket) {
        this.basket = basket;
    }

    @Override
    public Optional<Integer> get(int id) {
        return Optional.ofNullable(basket.get(id));
    }

    @Override
    public Basket getAll() {
        return basket;
    }

    @Override
    public boolean isEmpty() {
        return basket.isEmpty();
    }

    @Override
    public void add(int id, int amount) {
        basket.put(id, amount);
    }

    @Override
    public Basket copy() {
        return (Basket) basket.clone();
    }

    @Override
    public void clear() {
        basket.clear();
    }

    @Override
    public String toString() {
        return basket.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue)).toString();
    }
}
