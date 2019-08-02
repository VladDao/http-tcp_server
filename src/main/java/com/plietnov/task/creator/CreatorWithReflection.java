package com.plietnov.task.creator;

import com.plietnov.task.MyAnnotation;
import com.plietnov.task.Util;
import com.plietnov.task.entity.Product;
import com.plietnov.task.strategy.Strategy;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class CreatorWithReflection implements Creator {

    private static final Logger LOGGER = Logger.getLogger(CreatorWithReflection.class);
    private static final Class<Integer> INT = int.class;
    private static final Class<Double> DOUBLE = double.class;
    private Strategy strategy;
    private Product product;

    public CreatorWithReflection(Strategy strategy, Product product) {
        this.strategy = strategy;
        this.product = product;
    }

    @Override
    public Strategy getStrategy() {
        return strategy;
    }

    @Override
    public Product create() {
        return createProduct(product);
    }

    @Override
    public Product createProduct(Product product) {
        Method[] methods = product.getClass().getMethods();
        for (Method method : methods) {
            MyAnnotation my = method.getAnnotation(MyAnnotation.class);
            if (my != null) {
                initParameters(product, method);
            }
        }
        return product;
    }

    private void initParameters(Product product, Method method) {
        int i = 0;
        Object[] objects = new Object[method.getParameterCount()];
        for (Parameter parameter : method.getParameters()) {
            Class clazz = parameter.getClass();
            if (clazz == INT) {
                objects[i++] = strategy.getInt(Util.getResource(method.getAnnotation(MyAnnotation.class).key()));
            } else if (clazz == DOUBLE) {
                objects[i++] = strategy.getDouble(Util.getResource(method.getAnnotation(MyAnnotation.class).key()));
            } else {
                objects[i++] = strategy.getString(Util.getResource(method.getAnnotation(MyAnnotation.class).key()));
            }
        }
        try {
            method.invoke(product, objects);
        } catch (IllegalAccessException | InvocationTargetException e) {
            LOGGER.error(e);
        }
    }
}