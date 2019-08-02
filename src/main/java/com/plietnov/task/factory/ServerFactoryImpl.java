package com.plietnov.task.factory;

import com.plietnov.task.server.MyHTTPServer;
import com.plietnov.task.server.ServerTCP;

public class ServerFactoryImpl implements ServerFactory {

    @Override
    public void runTCPServer(ServerTCP tcpServer) {
        Thread threadTCP = new Thread(tcpServer::start);
        threadTCP.setDaemon(true);
        threadTCP.start();
    }

    @Override
    public void runHTTPServer(MyHTTPServer httpServer) {
        Thread threadHTTP = new Thread(httpServer::start);
        threadHTTP.setDaemon(true);
        threadHTTP.start();
    }
}
