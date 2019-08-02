package com.plietnov.task.service.implementation;

import com.plietnov.task.bean.LastFIveHashMap;
import com.plietnov.task.dao.implementation.ShopDao;
import com.plietnov.task.entity.Computer;
import com.plietnov.task.entity.Product;
import com.plietnov.task.service.ShopServiceInterface;
import org.apache.log4j.Logger;

public class ShopService implements ShopServiceInterface {

    private static final Logger LOGGER = Logger.getLogger(ShopService.class);
    private static final String ELEMENT_NOT_FOUND = "Element not found";
    private LastFIveHashMap lastFIve;
    private ShopDao shop;

    public ShopService(ShopDao shop, LastFIveHashMap lastFIve) {
        this.lastFIve = lastFIve;
        this.shop = shop;
    }

    @Override
    public Product get(int id) {
        if (shop.get(id).isPresent()) {
            return shop.get(id).get();
        }
        LOGGER.error(ELEMENT_NOT_FOUND);
        return null;
    }

    @Override
    public boolean containsId(int id) {
        return shop.get(id).isPresent();
    }

    @Override
    public void showAllPc() {
        shop.getAll().forEach(LOGGER::info);
    }

    @Override
    public int getCost(int id) {
        return ((Computer) shop.get(id).get()).getCost();
    }

    public int shopSize() {
        return shop.getAll().size();
    }

    @Override
    public void addToHistory(Product product) {
        if (lastFIve.isEmpty()) {
            lastFIve.put(0, product);
        } else {
            lastFIve.put(lastFIve.keySet().stream()
                    .max(Integer::compareTo).get(), product);
        }
    }

    public void addToShop(Product product) {
        shop.add(product);
    }

    @Override
    public LastFIveHashMap getLastFIve() {
        return lastFIve;
    }
}