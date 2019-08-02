package com.plietnov.task.dao;

import com.plietnov.task.bean.Orders;
import com.plietnov.task.entity.Computer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderDaoInterface {

    Optional<List<Computer>> get(LocalDateTime dateTime);

    void add(LocalDateTime dateTime, List list);

    Orders getAll();
}