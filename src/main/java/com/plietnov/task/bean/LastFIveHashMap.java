package com.plietnov.task.bean;

import com.plietnov.task.entity.Product;

import java.util.LinkedHashMap;
import java.util.Map;

public class LastFIveHashMap extends LinkedHashMap<Integer, Product> {

    private static final int NUMBER_LAST_ELEMENT = 5;

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > NUMBER_LAST_ELEMENT;
    }
}
