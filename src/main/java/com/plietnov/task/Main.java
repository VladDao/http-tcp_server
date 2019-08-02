package com.plietnov.task;

import com.plietnov.task.factory.ServerFactory;
import com.plietnov.task.factory.ServerFactoryImpl;

public class Main {

    public static void main(String... args) {
        Init init = new Init();
        init.init();
        ServerFactory serverFactory = new ServerFactoryImpl();
        serverFactory.runTCPServer(init.getServerTCP());
        serverFactory.runHTTPServer(init.getHTTPServer());
        Manager manager = new Manager(init.getCommandContainer());
        manager.start();
    }
}
