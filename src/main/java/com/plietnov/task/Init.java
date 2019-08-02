package com.plietnov.task;

import com.epam.rd.plietnov.task9.bean.*;
import com.epam.rd.plietnov.task9.command.*;
import com.plietnov.task.command.*;
import com.plietnov.task.command.server.GetProductCommandHTTP;
import com.plietnov.task.command.server.GetProductCommandTCP;
import com.plietnov.task.command.server.ShopSizeCommandHTTP;
import com.plietnov.task.command.server.ShopSizeCommandTCP;
import com.plietnov.task.dao.implementation.BasketDao;
import com.plietnov.task.dao.implementation.OrdersDao;
import com.plietnov.task.dao.implementation.ShopDao;
import com.plietnov.task.dao.implementation.StorageDao;
import com.plietnov.task.entity.Computer;
import com.plietnov.task.entity.Product;
import com.plietnov.task.file.FileReader;
import com.plietnov.task.file.FileWriter;
import com.plietnov.task.server.MyHTTPServer;
import com.plietnov.task.server.ServerTCP;
import com.plietnov.task.service.implementation.BasketService;
import com.plietnov.task.service.implementation.OrderService;
import com.plietnov.task.service.implementation.ShopService;
import com.plietnov.task.service.implementation.StorageService;
import com.plietnov.task.strategy.Strategy;
import com.plietnov.task.strategy.StrategyManual;
import com.plietnov.task.strategy.StrategyRandom;
import com.plietnov.task.bean.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Init {

    private static final Logger LOGGER = Logger.getLogger(Init.class);
    private static final String CHOOSE_STRATEGY = "choose_strategy";
    private static final String COMMAND_NOT_FOUND = "command_not_found";
    private static final int PORT_TCP = 3000;
    private static final int PORT_HTTP = 3001;
    private FileReader fileReader = new FileReader();
    private FileWriter fileWriter = new FileWriter();

    private ArrayList<Product> products;

    private Strategy strategy = new StrategyRandom();

    private Basket basket;
    private Orders orders;
    private Shop shop;
    private Storage storage;
    private LastFIveHashMap lastFIveHashMap;

    private BasketDao basketDao;
    private OrdersDao ordersDao;
    private ShopDao shopDao;
    private StorageDao storageDao;

    private ShopService shopService;
    private StorageService storageService;
    private BasketService basketService;
    private OrderService orderService;

    private CommandContainer commandContainer = new CommandContainer();

    private Controller controller;
    private ServerTCP serverTCP;
    private MyHTTPServer myHTTPServer;

    public void init() {
        initShop();
        initBean();
        initDao();
        initService();
        initCommand();
        serverInit();
    }

    private void serverInit() {
        controller = new Controller(commandContainer);
        serverTCP = new ServerTCP(PORT_TCP, controller);
        myHTTPServer = new MyHTTPServer(PORT_HTTP, controller);
    }

    private void chooseStrategy() {
        Map<String, Strategy> strategies = new HashMap<>();
        strategies.put("1", new StrategyRandom());
        strategies.put("2", new StrategyManual());
        LOGGER.info(Util.getResource(CHOOSE_STRATEGY));
        String input = Util.readFromConsole();
        if (strategies.containsKey(input)) {
            strategy = strategies.get(input);
        } else {
            LOGGER.error(Util.getResource(COMMAND_NOT_FOUND));
            chooseStrategy();
        }
    }

    private void initShop() {
        products = new ArrayList<>();
        products.add(new Computer(1, "First", "first", "first", 100));
        products.add(new Computer(2, "test", "test", "test", 200));
    }

    private void initBean() {
        basket = fileReader.read();
        orders = new Orders();
        shop = new Shop(products);
        storage = new Storage();
        lastFIveHashMap = new LastFIveHashMap();
    }

    private void initDao() {
        basketDao = new BasketDao(basket);
        ordersDao = new OrdersDao(orders);
        shopDao = new ShopDao(shop);
        storageDao = new StorageDao(storage);
    }

    private void initService() {
        shopService = new ShopService(shopDao, lastFIveHashMap);
        storageService = new StorageService(storageDao);
        basketService = new BasketService(basketDao);
        orderService = new OrderService(ordersDao);
    }

    public CommandContainer getCommandContainer() {
        return commandContainer;
    }

    public ServerTCP getServerTCP() {
        return serverTCP;
    }

    public MyHTTPServer getHTTPServer() {
        return myHTTPServer;
    }

    private void initCommand() {
        commandContainer.init("1", new AddToBasketCommand(basketService, shopService));
        commandContainer.init("2", new BuyProductsCommand(basketService, shopService, storageService));
        commandContainer.init("3", new ShowBasketCommand(basketService, shopService));
        commandContainer.init("4", new ShowProductsCommand(shopService));
        commandContainer.init("5", new ShowLastFiveCommand(shopService));
        commandContainer.init("6", new MakeOrderCommand(orderService, shopService));
        commandContainer.init("7", new ShowOrderInRangeCommand(orderService));
        commandContainer.init("8", new FindOrderCommand(orderService));
        commandContainer.init("9", new AddToShopCommand(shopService, strategy));
        commandContainer.init("10", new ChangeLanguageCommand());
        commandContainer.init("0", new ExitCommand(this));
        commandContainer.init("count", new ShopSizeCommandTCP(shopService));
        commandContainer.init("item", new GetProductCommandTCP(shopService));
        commandContainer.init("json-count", new ShopSizeCommandHTTP(shopService));
        commandContainer.init("get_info", new GetProductCommandHTTP(shopService));
    }

    public void destructor() {
        fileWriter.write(basket);
    }
}
