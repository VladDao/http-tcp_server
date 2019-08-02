package com.plietnov.task.service.implementation;

import com.plietnov.task.bean.Basket;
import com.plietnov.task.dao.implementation.BasketDao;
import com.plietnov.task.service.BasketServiceInterface;

public class BasketService implements BasketServiceInterface {

    private BasketDao basketDao;

    public BasketService(BasketDao basketDao) {
        this.basketDao = basketDao;
    }

    @Override
    public void addProduct(int id) {
        if (basketDao.getAll().containsKey(id)) {
            basketDao.add(id, basketDao.get(id).get() + 1);
        } else {
            basketDao.add(id, 1);
        }
    }

    @Override
    public void clearBasket() {
        basketDao.clear();
    }

    @Override
    public Basket getBasket() {
        return basketDao.getAll();
    }

    public boolean isEmpty() {
        return basketDao.isEmpty();
    }
}