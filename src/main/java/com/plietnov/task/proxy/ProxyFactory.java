package com.plietnov.task.proxy;

import com.plietnov.task.entity.intef.ComputerInterface;

import java.lang.reflect.Proxy;

public class ProxyFactory {

    private ProxyFactory() {
    }

    public static ComputerInterface newInstanceUnmodProxy(ComputerInterface instance) {
        return (ComputerInterface) Proxy.newProxyInstance(instance.getClass().getClassLoader(),
                new Class<?>[]{ComputerInterface.class},
                new UnmodProxy(instance));
    }

    public static ComputerInterface newInstanceMapProxy(ComputerInterface instance) {
        return (ComputerInterface) Proxy.newProxyInstance(instance.getClass().getClassLoader(),
                new Class<?>[]{ComputerInterface.class},
                new ProxyMap(instance));
    }
}
