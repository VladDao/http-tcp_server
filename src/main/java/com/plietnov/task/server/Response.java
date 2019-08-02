package com.plietnov.task.server;

public class Response {

    private StringBuilder stringBuilder = new StringBuilder();

    public Response() {
        stringBuilder = new StringBuilder();
    }

    public void clear() {
        stringBuilder = new StringBuilder();
    }

    public void add(String in) {
        stringBuilder.append(in);
    }

    public String getResponce() {
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
