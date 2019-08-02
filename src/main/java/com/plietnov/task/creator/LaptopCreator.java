package com.plietnov.task.creator;

import com.plietnov.task.Util;
import com.plietnov.task.entity.Laptop;
import com.plietnov.task.entity.Product;
import com.plietnov.task.strategy.Strategy;

public class LaptopCreator extends ComputerCreator {

    private static final String PRODUCT_DESCRIPTION = "product_description";

    public LaptopCreator(Strategy strategy) {
        super(strategy);
    }

    @Override
    public Product create() {
        return createProduct(new Laptop());
    }

    @Override
    public Laptop createProduct(Product product) {
        Laptop laptop = (Laptop) super.createProduct(product);
        laptop.setDescription(getStrategy().getString(Util.getResource(PRODUCT_DESCRIPTION)));
        return laptop;
    }
}
