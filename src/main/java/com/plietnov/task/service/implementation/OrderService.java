package com.plietnov.task.service.implementation;

import com.plietnov.task.Util;
import com.plietnov.task.dao.implementation.OrdersDao;
import com.plietnov.task.entity.Computer;
import com.plietnov.task.entity.Product;
import com.plietnov.task.service.OrderServiceInterface;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

public class OrderService implements OrderServiceInterface {

    private static final Logger LOGGER = Logger.getLogger(OrderService.class);
    private static final String BASKET_IS_EMPTY = "basket is empty";
    private static final String ORDER_IS_EMPTY = "Orders is empty";
    private static final String ENTER_DATE = "Please enter date (dd-MM-yyyy HH:mm)";

    private OrdersDao ordersDao;
    private List<Computer> pc = new ArrayList<>();

    public OrderService(OrdersDao orders) {
        this.ordersDao = orders;
    }

    @Override
    public void addToOrder(Product product) {
        pc.add((Computer) product);
    }

    @Override
    public void doOrder() {
        if (pc.isEmpty()) {
            LOGGER.error(BASKET_IS_EMPTY);
        } else {
            LOGGER.info(ENTER_DATE);
            ordersDao.add(Util.readDateFromConsole(), pc);
        }
    }

    @Override
    public void findOrder(LocalDateTime inputDate) {
        if (ordersDao.getAll().isEmpty()) {
            LOGGER.info(ORDER_IS_EMPTY);
            return;
        }
        if (ordersDao.getAll().keySet().contains(inputDate)) {
            showOrders(inputDate, ordersDao.getAll().get(inputDate));
        } else {
            LocalDateTime res = getNearestKey(inputDate);
            showOrders(res, ordersDao.get(res).get());
        }
    }

    @Override
    public void showOrderInRange(LocalDateTime start, LocalDateTime end) {
        if (ordersDao.getAll().isEmpty()) {
            LOGGER.info(ORDER_IS_EMPTY);
        } else {
            SortedMap o = ordersDao.getAll().subMap(start, end);
            o.forEach((k, v) -> LOGGER.info(k + "==>" + v));
        }
    }

    private LocalDateTime getNearestKey(LocalDateTime inputDate) {
        long higherKey = localDTtoMilli(ordersDao.getAll().higherKey(inputDate));
        long lowerKey = localDTtoMilli(ordersDao.getAll().lowerKey(inputDate));
        return Math.abs(higherKey - localDTtoMilli(inputDate)) >
                Math.abs(lowerKey - localDTtoMilli(inputDate)) ?
                ordersDao.getAll().lowerKey(inputDate) : ordersDao.getAll().higherKey(inputDate);
    }

    private void showOrders(LocalDateTime dateTime, List list) {
        LOGGER.info(dateTime + " " + list.toString());
    }

    private long localDTtoMilli(LocalDateTime localDateTime) {
        return localDateTime != null ?
                localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli() : 0;
    }
}