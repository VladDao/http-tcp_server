package com.plietnov.task.command.server;

import com.plietnov.task.command.Command;
import com.plietnov.task.server.Response;
import com.plietnov.task.service.implementation.ShopService;

public class ShopSizeCommandTCP extends Command implements CommandServer {

    private ShopService shop;

    public ShopSizeCommandTCP(ShopService shop) {
        this.shop = shop;
    }

    @Override
    public void execute() {
    }

    @Override
    public void execute(String request, Response response) {
        response.add(String.valueOf(shop.shopSize()));
    }
}
