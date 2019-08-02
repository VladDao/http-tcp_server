package com.plietnov.task.creator;

import com.plietnov.task.Util;
import com.plietnov.task.entity.Product;
import com.plietnov.task.strategy.Strategy;

public abstract class ProductCreator implements Creator {

    private static final String PRODUCT_NAME = "product_name";
    private static final String PRODUCT_ID = "product_id";
    private Strategy strategy;

    public ProductCreator(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    @Override
    public Product createProduct(Product product) {
        product.setId(strategy.getInt(Util.getResource(PRODUCT_ID)));
        product.setNameOfProduct(strategy.getString(Util.getResource(PRODUCT_NAME)));
        return product;
    }
}
