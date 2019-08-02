package com.plietnov.task.command;

import com.plietnov.task.service.implementation.ShopService;
import org.apache.log4j.Logger;

public class ShowLastFiveCommand extends Command {

    private static final Logger LOGGER = Logger.getLogger(ShowBasketCommand.class);
    private ShopService shopService;

    public ShowLastFiveCommand(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public void execute() {
        shopService.getLastFIve().forEach((k, v) -> LOGGER.info(v));
    }
}
