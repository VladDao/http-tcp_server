package com.plietnov.task.command;

import com.plietnov.task.Util;
import com.plietnov.task.service.implementation.BasketService;
import com.plietnov.task.service.implementation.ShopService;
import com.plietnov.task.service.implementation.StorageService;
import org.apache.log4j.Logger;

public class BuyProductsCommand extends Command {

    private static final Logger LOGGER = Logger.getLogger(BuyProductsCommand.class);
    private static final String BASKET_IS_EMPTY = "basket_is_empty";
    private static final String BUY_QUESTION = "buy_question";
    private static final String COST = "cost";

    private BasketService serviceBasket;
    private ShopService shopService;
    private StorageService storageService;

    public BuyProductsCommand(BasketService serviceBasket, ShopService shopService, StorageService storageService) {
        this.serviceBasket = serviceBasket;
        this.shopService = shopService;
        this.storageService = storageService;
    }

    @Override
    public void execute() {
        if (serviceBasket.isEmpty()) {
            LOGGER.error(Util.getResource(BASKET_IS_EMPTY));
        } else {
            LOGGER.info(Util.getResource(BUY_QUESTION));
            int cost = serviceBasket.getBasket().entrySet().stream()
                    .mapToInt(k -> (shopService.getCost(k.getKey()) * k.getValue()))
                    .sum();
            LOGGER.info(COST + cost);
            if ("y".equals(Util.readFromConsole())) {
                storageService.add(serviceBasket.getBasket());
                serviceBasket.clearBasket();
            }
        }
    }
}