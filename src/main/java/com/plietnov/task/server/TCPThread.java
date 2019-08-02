package com.plietnov.task.server;

import com.plietnov.task.Controller;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPThread extends Thread {

    private static final Logger LOGGER = Logger.getLogger(TCPThread.class);
    private Socket clientSocket;
    private Controller controller;
    private PrintWriter out;
    private BufferedReader in;

    public TCPThread(Socket clientSocket, Controller controller) {
        this.clientSocket = clientSocket;
        this.controller = controller;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String input = in.readLine();
            Response response = new Response();
            LOGGER.info(input);
            controller.commandProcessTCP(input, response);
            out.println(response);
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}
