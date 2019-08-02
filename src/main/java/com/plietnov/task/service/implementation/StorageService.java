package com.plietnov.task.service.implementation;

import com.plietnov.task.bean.Basket;
import com.plietnov.task.dao.implementation.StorageDao;
import com.plietnov.task.service.StorageServiceInterface;
import org.apache.log4j.Logger;

public class StorageService implements StorageServiceInterface {

    private static final Logger LOGGER = Logger.getLogger(StorageService.class);
    private static final String BASKET_IS_EMPTY = "basket_is_empty";

    private StorageDao storageDao;

    public StorageService(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void add(Basket basket) {
        if (basket.isEmpty()) {
            LOGGER.error(BASKET_IS_EMPTY);
        }
        storageDao.add(basket);
    }
}