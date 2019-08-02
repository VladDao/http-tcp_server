package com.plietnov.task.command;

import com.plietnov.task.Util;
import com.plietnov.task.service.implementation.OrderService;
import org.apache.log4j.Logger;

public class FindOrderCommand extends Command {

    private static final Logger LOGGER = Logger.getLogger(FindOrderCommand.class);
    private static final String ENTER_DATE = "enter_date";

    private OrderService orderService;

    public FindOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute() {
        LOGGER.info(Util.getResource(ENTER_DATE));
        orderService.findOrder(Util.readDateFromConsole());
    }
}