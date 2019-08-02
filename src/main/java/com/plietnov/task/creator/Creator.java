package com.plietnov.task.creator;

import com.plietnov.task.entity.Product;
import com.plietnov.task.strategy.Strategy;

public interface Creator {

    Strategy getStrategy();

    Product createProduct(Product product);

    Product create();
}
