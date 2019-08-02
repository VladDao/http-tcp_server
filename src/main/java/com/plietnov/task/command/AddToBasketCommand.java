package com.plietnov.task.command;

import com.plietnov.task.Util;
import com.plietnov.task.entity.Product;
import com.plietnov.task.service.implementation.BasketService;
import com.plietnov.task.service.implementation.ShopService;
import com.plietnov.task.validator.ValidationDigit;
import org.apache.log4j.Logger;

public class AddToBasketCommand extends Command {

    private static final Logger LOGGER = Logger.getLogger(AddToBasketCommand.class);
    private static final String ENTER_PRODUCT_ID = "enter_product_id";
    private static final String INCORRECT_INPUT = "incorrect_input";
    private static final String PRODUCT_IS_MISSING = "product_not_found";
    private static final String PRODUCT_ADDED = "product_added";

    private BasketService basketService;
    private ShopService shopService;

    public AddToBasketCommand(BasketService basketService, ShopService shopService) {
        this.basketService = basketService;
        this.shopService = shopService;
    }

    @Override
    public void execute() {
        shopService.showAllPc();
        LOGGER.info(Util.getResource(ENTER_PRODUCT_ID));
        String input = Util.readFromConsole();
        if (!ValidationDigit.isDigit(input)) {
            LOGGER.error(Util.getResource(INCORRECT_INPUT));
            return;
        }
        Product product = shopService.get(Integer.parseInt(input));
        if (product == null) {
            LOGGER.error(Util.getResource(PRODUCT_IS_MISSING));
            return;
        }
        basketService.addProduct(product.getId());
        shopService.addToHistory(product);
        LOGGER.info(Util.getResource(PRODUCT_ADDED));
    }
}