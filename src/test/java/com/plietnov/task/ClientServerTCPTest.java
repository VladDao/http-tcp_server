package com.plietnov.task;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

public class ClientServerTCPTest {
    private static final String LS = System.lineSeparator();
    private static final Logger LOGGER = Logger.getLogger(ClientServerTCPTest.class);
    private static final int PORT = 3000;


    @Test
    public void testServer_count() {
        Client client = new Client();
        client.startConnection("127.0.0.1", PORT);
        String response = client.sendMessage("get count");
        LOGGER.info(response);
        client.stopConnection();
    }

    @Test
    public void testServer_item() {
        Client client = new Client();
        client.startConnection("127.0.0.1", PORT);
        String response = client.sendMessage("get item=1");
        LOGGER.info(response);
        client.stopConnection();
    }
}
