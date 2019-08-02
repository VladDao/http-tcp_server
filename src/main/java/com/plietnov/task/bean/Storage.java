package com.plietnov.task.bean;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Storage {

    private Map<LocalDateTime, Basket> storageMap = new HashMap<>();

    public void put(LocalDateTime time, Basket basket) {
        storageMap.put(time, basket);
    }

    public Basket get(LocalDateTime time) {
        return storageMap.get(time);
    }
}
