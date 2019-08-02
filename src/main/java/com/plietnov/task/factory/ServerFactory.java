package com.plietnov.task.factory;

import com.plietnov.task.server.MyHTTPServer;
import com.plietnov.task.server.ServerTCP;

public interface ServerFactory {

    void runTCPServer(ServerTCP tcpServer);

    void runHTTPServer(MyHTTPServer myHTTPServer);
}
