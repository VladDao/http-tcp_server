package com.plietnov.task.factory;

import com.plietnov.task.entity.Computer;
import com.plietnov.task.entity.ElectricalAppliance;
import com.plietnov.task.entity.Laptop;

public class ProductFactory {

    public static ElectricalAppliance createProduct(int id, String productName, String type) {
        return new ElectricalAppliance(id, productName, type);
    }

    public static Computer createProduct(int id, String productName, String type, String classification, int cost) {
        return new Computer(id, productName, type, classification, cost);
    }

    private static Laptop createProduct(int id, String nameOfProduct, String type, String classification, String description, int cost) {
        return new Laptop(id, nameOfProduct, type, classification, description, cost);
    }
}
