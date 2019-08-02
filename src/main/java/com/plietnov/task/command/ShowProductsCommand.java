package com.plietnov.task.command;

import com.plietnov.task.service.implementation.ShopService;

public class ShowProductsCommand extends Command {

    private ShopService shopService;

    public ShowProductsCommand(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public void execute() {
        shopService.showAllPc();
    }
}
