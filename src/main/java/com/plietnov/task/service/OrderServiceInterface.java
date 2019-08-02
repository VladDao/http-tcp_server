package com.plietnov.task.service;

import com.plietnov.task.entity.Product;

import java.time.LocalDateTime;

public interface OrderServiceInterface {

    void addToOrder(Product product);

    void doOrder();

    void showOrderInRange(LocalDateTime start, LocalDateTime end);

    void findOrder(LocalDateTime inputDate);
}
