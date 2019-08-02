package com.plietnov.task.command.server;

import com.plietnov.task.Util;
import com.plietnov.task.command.Command;
import com.plietnov.task.entity.Computer;
import com.plietnov.task.server.Response;
import com.plietnov.task.service.implementation.ShopService;

public class GetProductCommandHTTP extends Command implements CommandServer {

    private ShopService shopService;

    public GetProductCommandHTTP(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public void execute() {
    }

    @Override
    public void execute(String request, Response response) {
        Computer computer = (Computer) shopService.get(Integer.parseInt(request));
        response.add(Util.productToJson(computer));
    }
}
