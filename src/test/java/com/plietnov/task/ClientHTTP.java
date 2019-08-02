package com.plietnov.task;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ClientHTTP {
    private static final String LS = System.lineSeparator();
    private static final Logger LOGGER = Logger.getLogger(ClientServerTCPTest.class);
    private static final int PORT = 3001;

    //    @Test
//    public void testServer_count() {
//        Client client = new Client();
//        client.startConnection("127.0.0.1", PORT);
//        System.out.println(client);
//        String response = client.sendMessage("/shop/count");
//        LOGGER.info(response);
//        client.stopConnection();
//    }
    @Test
    public void testServer_count() {
        URL server = null;
        URLConnection conexion = null;
        BufferedReader reader = null;
        try {
            server = new URL("http://localhost:3001/shop/count");
            conexion = server.openConnection();
            reader = new BufferedReader(new InputStreamReader(server.openStream()));
            LOGGER.info(reader.readLine());
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    @Test
    public void testServer_item() {
        URL server = null;
        URLConnection conexion = null;
        BufferedReader reader = null;
        try {
            server = new URL("http://localhost:3001/shop/item?get_info=1");
            conexion = server.openConnection();
            reader = new BufferedReader(new InputStreamReader(server.openStream()));
            LOGGER.info(reader.readLine());
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}
