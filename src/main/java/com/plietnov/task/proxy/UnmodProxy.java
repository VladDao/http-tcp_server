package com.plietnov.task.proxy;

import com.plietnov.task.entity.intef.ComputerInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UnmodProxy implements InvocationHandler {

    private static final String SET = "set";
    private ComputerInterface computerInterface;

    public UnmodProxy(ComputerInterface computerInterface) {
        this.computerInterface = computerInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith(SET)) {
            throw new UnsupportedOperationException();
        }
        return method.invoke(computerInterface, args);
    }
}
