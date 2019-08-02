package com.plietnov.task.dao.implementation;

import com.plietnov.task.bean.Orders;
import com.plietnov.task.dao.OrderDaoInterface;
import com.plietnov.task.entity.Computer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class OrdersDao implements OrderDaoInterface {

    private Orders orders;

    public OrdersDao(Orders orders) {
        this.orders = orders;
    }

    @Override
    public Optional<List<Computer>> get(LocalDateTime time) {
        return Optional.ofNullable(orders.get(time));
    }

    @Override
    public void add(LocalDateTime localDateTime, List basket) {
        orders.put(localDateTime, basket);
    }

    @Override
    public Orders getAll() {
        return orders;
    }
}
