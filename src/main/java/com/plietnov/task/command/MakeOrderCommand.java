package com.plietnov.task.command;

import com.plietnov.task.Util;
import com.plietnov.task.entity.Product;
import com.plietnov.task.service.implementation.OrderService;
import com.plietnov.task.service.implementation.ShopService;
import com.plietnov.task.validator.ValidationDigit;
import org.apache.log4j.Logger;

public class MakeOrderCommand extends Command {

    private static final Logger LOGGER = Logger.getLogger(MakeOrderCommand.class);
    private static final String ENTER_PRODUCT_ID_OR_A = "enter_product_id_or_a";
    private static final String INVALID_INPUT = "invalid_input";

    private OrderService orderService;
    private ShopService shopService;

    public MakeOrderCommand(OrderService orderService, ShopService shopService) {
        this.orderService = orderService;
        this.shopService = shopService;
    }

    @Override
    public void execute() {
        shopService.showAllPc();
        LOGGER.info(Util.getResource(ENTER_PRODUCT_ID_OR_A));
        String input;
        do {
            input = Util.readFromConsole();
            if (!ValidationDigit.isDigit(input)) {
                LOGGER.error(Util.getResource(INVALID_INPUT));
                break;
            }
            int id = Integer.parseInt(input);
            Product product = shopService.get(id);
            shopService.addToHistory(product);
            orderService.addToOrder(product);
        } while ("a".equals(input));
        orderService.doOrder();
    }
}