package com.plietnov.task.creator;

import com.plietnov.task.Util;
import com.plietnov.task.entity.Computer;
import com.plietnov.task.entity.Product;
import com.plietnov.task.strategy.Strategy;

public class ComputerCreator extends ElectricalApplianceCreator {

    private static final String PRODUCT_COST = "product_cost";
    private static final String PRODUCT_CLASS = "product_class";

    public ComputerCreator(Strategy strategy) {
        super(strategy);
    }

    @Override
    public Product create() {
        return createProduct(new Computer());
    }

    @Override
    public Computer createProduct(Product product) {
        Computer computer = (Computer) super.createProduct(product);
        computer.setClassification(getStrategy().getString(Util.getResource(PRODUCT_CLASS)));
        computer.setCost(getStrategy().getInt(Util.getResource(PRODUCT_COST)));
        return computer;
    }
}
