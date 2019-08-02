package com.plietnov.task.command;

import com.plietnov.task.Util;
import com.plietnov.task.creator.ComputerCreator;
import com.plietnov.task.creator.Creator;
import com.plietnov.task.creator.CreatorWithReflection;
import com.plietnov.task.creator.ElectricalApplianceCreator;
import com.plietnov.task.creator.LaptopCreator;
import com.plietnov.task.entity.Computer;
import com.plietnov.task.entity.ElectricalAppliance;
import com.plietnov.task.entity.Laptop;
import com.plietnov.task.service.implementation.ShopService;
import com.plietnov.task.strategy.Strategy;
import com.plietnov.task.validator.ValidationDigit;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class AddToShopCommand extends Command {

    private static final Logger LOGGER = Logger.getLogger(AddToShopCommand.class);
    private static final String CHOOSE_TYPE = "choose_type";
    private ShopService shopService;
    private Strategy strategy;
    private Map<String, Creator> creator = new HashMap<>();

    public AddToShopCommand(ShopService shopService, Strategy strategy) {
        this.shopService = shopService;
        this.strategy = strategy;
    }

    @Override
    public void execute() {
        initCreator();
        LOGGER.info(Util.getResource(CHOOSE_TYPE));
        String input = Util.readFromConsole();
        if (ValidationDigit.isDigit(input) && creator.containsKey(input)) {
            shopService.addToShop(creator.get(input).create());
        }
    }

    private void initCreator() {
        creator.put("1", new ComputerCreator(strategy));
        creator.put("2", new ElectricalApplianceCreator(strategy));
        creator.put("3", new LaptopCreator(strategy));
        creator.put("4", new CreatorWithReflection(strategy, new Computer()));
        creator.put("5", new CreatorWithReflection(strategy, new ElectricalAppliance()));
        creator.put("6", new CreatorWithReflection(strategy, new Laptop()));
    }
}