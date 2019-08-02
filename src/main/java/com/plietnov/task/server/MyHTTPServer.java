package com.plietnov.task.server;

import com.plietnov.task.Controller;
import com.plietnov.task.entity.Computer;
import com.plietnov.task.entity.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpPrincipal;
import com.sun.net.httpserver.HttpServer;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.*;

public class MyHTTPServer {

    private static final Logger LOGGER = Logger.getLogger(MyHTTPServer.class);
    private static final String CONTEXT_COUNT = "/shop/count";
    private static final String CONTEXT_ITEM = "/shop/item";
    private static final String JSON_COUNT = "json-count";
    private int port;
    private Controller controller;

    public MyHTTPServer(int port, Controller controller) {
        this.port = port;
        this.controller = controller;
    }

    public void start() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
            server.createContext(CONTEXT_COUNT)
                    .setHandler(this::handleCount);
            server.createContext(CONTEXT_ITEM)
                    .setHandler(this::handleItem);
            server.start();
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    private void handleCount(HttpExchange exchange) throws IOException {
        Response result = new Response();
        controller.commandHTTPWithoutArg(JSON_COUNT, result);
        printRequestInfo(exchange);
        exchange.sendResponseHeaders(200, result.toString().getBytes().length);
        OutputStream os = exchange.getResponseBody();
        System.out.println(os);
        os.write(result.toString().getBytes());
        os.close();
    }

    private void handleItem(HttpExchange exchange) throws IOException {
        URI requestURI = exchange.getRequestURI();
        Response result = new Response();
        List<NameValuePair> param = splitQuery(requestURI.getQuery());
        controller.commandProcessHTTP(param, result);
        printRequestInfo(exchange);
        String response = result.toString();
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    public List<NameValuePair> splitQuery(String query) {
        return URLEncodedUtils.parse(query, Charset.forName("UTF-8"));
    }

    public String productToJson(Product computer) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(computer);
    }

    public Product jsonToProduct(String computer) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.fromJson(computer, Computer.class);
    }

    private static void printRequestInfo(HttpExchange exchange) {
        LOGGER.info("-- headers --");
        Headers requestHeaders = exchange.getRequestHeaders();
        requestHeaders.entrySet().forEach(LOGGER::info);
        LOGGER.info("-- principle --");
        HttpPrincipal principal = exchange.getPrincipal();
        LOGGER.info(principal);
        LOGGER.info("-- HTTP method --");
        String requestMethod = exchange.getRequestMethod();
        LOGGER.info(requestMethod);
        LOGGER.info("-- query --");
        URI requestURI = exchange.getRequestURI();
        String query = requestURI.getQuery();
        LOGGER.info(query);
    }
}
