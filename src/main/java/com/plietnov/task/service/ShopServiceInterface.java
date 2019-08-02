package com.plietnov.task.service;

import com.plietnov.task.bean.LastFIveHashMap;
import com.plietnov.task.entity.Product;

public interface ShopServiceInterface {

    boolean containsId(int id);

    void showAllPc();

    int getCost(int id);

    Product get(int id);

    void addToHistory(Product product);

    LastFIveHashMap getLastFIve();
}
