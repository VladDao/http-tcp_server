package com.plietnov.task.command.server;

import com.plietnov.task.server.Response;

public interface CommandServer {

     void execute(String request, Response response);
}
