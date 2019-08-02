package com.plietnov.task;

import com.plietnov.task.entity.Computer;
import com.plietnov.task.server.MyHTTPServer;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

public class GsonTest {

    private static final Logger LOGGER = Logger.getLogger(GsonTest.class);

    private Computer computer = new Computer(1,
            "test",
            "someType",
            "PC",
            300);
    MyHTTPServer myHTTPServer = new MyHTTPServer(3000, new Controller());

    @Test
    public void test() {
        String res = myHTTPServer.productToJson(computer);
        LOGGER.info(res);
        LOGGER.info(myHTTPServer.jsonToProduct(res));
    }
}
