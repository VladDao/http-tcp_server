package com.plietnov.task.dao.implementation;

import com.plietnov.task.bean.Basket;
import com.plietnov.task.bean.Storage;
import com.plietnov.task.dao.StorageDaoInterface;

import java.time.LocalDateTime;
import java.util.Optional;

public class StorageDao implements StorageDaoInterface {

    private Storage storage;

    public StorageDao(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void add(Basket basket) {
        storage.put(LocalDateTime.now(), basket);
    }

    @Override
    public Optional<Basket> get(LocalDateTime id) {
        return Optional.ofNullable(storage.get(id));
    }
}
