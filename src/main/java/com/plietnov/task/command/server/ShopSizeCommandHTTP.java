package com.plietnov.task.command.server;

import com.plietnov.task.command.Command;
import com.plietnov.task.server.Response;
import com.plietnov.task.service.implementation.ShopService;
import org.json.JSONObject;

public class ShopSizeCommandHTTP extends Command implements CommandServer {

    private ShopService shop;
    private static final String COUNT = "count";


    public ShopSizeCommandHTTP(ShopService shop) {
        this.shop = shop;
    }

    @Override
    public void execute() {
    }

    @Override
    public void execute(String request, Response response) {
        JSONObject jo = new JSONObject();
        jo.put(COUNT, shop.shopSize());
        response.add(jo.toString());
    }

}
