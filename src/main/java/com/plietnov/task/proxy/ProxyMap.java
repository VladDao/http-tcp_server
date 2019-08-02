package com.plietnov.task.proxy;

import com.plietnov.task.entity.intef.ComputerInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ProxyMap implements InvocationHandler {

    private static final int THREE = 3;
    private static final int ZERO = 0;
    private static final String SET = "get";
    private static final String GET = "get";
    private Map<String, Object> map = new HashMap<>();
    private ComputerInterface target;

    public ProxyMap(ComputerInterface target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        String name = method.getName().substring(THREE);
        if (method.getName().startsWith(SET)) {
            return map.put(name, args[ZERO]);
        }
        if (method.getName().startsWith(GET)) {
            return map.get(name);
        }
        return method.invoke(target, args);
    }
}
