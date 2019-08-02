package com.plietnov.task.server;

import com.plietnov.task.Controller;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {

    private boolean flag = false;
    private static final Logger LOGGER = Logger.getLogger(ServerTCP.class);

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private Controller controller;
    private int port;

    public ServerTCP() {
    }

    public ServerTCP(int port, Controller controller) {
        this.port = port;
        this.controller = controller;
    }

    public void start() {
        flag = true;
        try {
            serverSocket = new ServerSocket(port);
            while (flag) {
                clientSocket = serverSocket.accept();
                Thread thr = new TCPThread(clientSocket, controller);
                thr.setDaemon(true);
                thr.start();
            }
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    public void stop() {
        flag = false;
        try {
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}
