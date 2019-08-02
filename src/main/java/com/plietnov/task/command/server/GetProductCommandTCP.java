package com.plietnov.task.command.server;

import com.plietnov.task.command.Command;
import com.plietnov.task.entity.Computer;
import com.plietnov.task.server.Response;
import com.plietnov.task.service.implementation.ShopService;

public class GetProductCommandTCP extends Command implements CommandServer {

    private ShopService shopService;

    public GetProductCommandTCP(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public void execute() {
    }

    @Override
    public void execute(String request, Response response) {
        Computer computer = (Computer) shopService.get(Integer.parseInt(request));
        response.add(computer.getNameOfProduct() + "|");
        response.add(String.valueOf(computer.getCost()));
    }
}
