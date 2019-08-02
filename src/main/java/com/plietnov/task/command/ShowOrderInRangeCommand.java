package com.plietnov.task.command;

import com.plietnov.task.Util;
import com.plietnov.task.service.implementation.OrderService;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;

public class ShowOrderInRangeCommand extends Command {

    private static final Logger LOGGER = Logger.getLogger(ShowOrderInRangeCommand.class);
    private static final String ENTER_DATE_FIRST = "enter_date_first";
    private static final String ENTER_DATE_LAST = "enter_date_last";

    private OrderService orderService;

    public ShowOrderInRangeCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute() {
        LOGGER.info(Util.getResource(ENTER_DATE_FIRST));
        LocalDateTime firstDate = Util.readDateFromConsole();
        if (firstDate == null) {
            return;
        }
        LOGGER.info(Util.getResource(ENTER_DATE_LAST));
        orderService.showOrderInRange(firstDate, Util.readDateFromConsole());
    }
}