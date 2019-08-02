package com.plietnov.task.dao;

import com.plietnov.task.bean.Basket;

import java.time.LocalDateTime;
import java.util.Optional;

public interface StorageDaoInterface {

    void add(Basket basket);

    Optional<Basket> get(LocalDateTime id);
}
