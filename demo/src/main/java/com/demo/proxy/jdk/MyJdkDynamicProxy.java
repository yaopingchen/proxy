package com.demo.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyJdkDynamicProxy implements InvocationHandler {
    private Object object;
    public MyJdkDynamicProxy(Object object){
        this.object=object;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("pre invoke");
        method.invoke(object,args);
        System.out.println("after invoke");
        return null;
    }
}
