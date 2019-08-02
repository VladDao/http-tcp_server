package com.plietnov.task.creator;

import com.plietnov.task.Util;
import com.plietnov.task.entity.ElectricalAppliance;
import com.plietnov.task.entity.Product;
import com.plietnov.task.strategy.Strategy;

public class ElectricalApplianceCreator extends ProductCreator {

    private static final String PRODUCT_TYPE = "product_type";

    public ElectricalApplianceCreator(Strategy strategy) {
        super(strategy);
    }

    @Override
    public Product create() {
        return createProduct(new ElectricalAppliance());
    }

    @Override
    public ElectricalAppliance createProduct(Product product) {
        ElectricalAppliance electricalAppliance = (ElectricalAppliance) super.createProduct(product);
        electricalAppliance.setType(getStrategy().getString(Util.getResource(PRODUCT_TYPE)));
        return electricalAppliance;
    }
}
