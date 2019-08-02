package com.plietnov.task.command;

import com.plietnov.task.service.implementation.BasketService;
import com.plietnov.task.service.implementation.ShopService;
import org.apache.log4j.Logger;

public class ShowBasketCommand extends Command {

    private static final Logger LOGGER = Logger.getLogger(ShowBasketCommand.class);
    private BasketService basketService;
    private ShopService shopService;

    public ShowBasketCommand(BasketService basketService, ShopService shopService) {
        this.basketService = basketService;
        this.shopService = shopService;
    }

    @Override
    public void execute() {
        basketService.getBasket().forEach((k, v) -> LOGGER.info(shopService.get(k) + "= " + v));
    }
}