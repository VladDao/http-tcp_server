package com.plietnov.task.dao.implementation;

import com.plietnov.task.Util;
import com.plietnov.task.bean.Shop;
import com.plietnov.task.dao.ShopDaoInterface;
import com.plietnov.task.entity.Product;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class ShopDao implements ShopDaoInterface {

    private static final Logger LOGGER = Logger.getLogger(ShopDao.class);
    private static final String PRODUCT_ALREADY_HAVE = "product_already_have";
    private Shop shop;

    public ShopDao(Shop shop) {
        this.shop = shop;
    }

    public void add(Product product) {
        if (get(product.getId()).isPresent()) {
            LOGGER.error(Util.getResource(PRODUCT_ALREADY_HAVE));
        }
        shop.add(product);
    }

    @Override
    public Optional<Product> get(int id) {
        return Optional.ofNullable(shop.get(id));
    }

    @Override
    public void showAll() {
        shop.getAll().forEach(LOGGER::info);
    }

    @Override
    public List<Product> getAll() {
        return shop.getAll();
    }
}
