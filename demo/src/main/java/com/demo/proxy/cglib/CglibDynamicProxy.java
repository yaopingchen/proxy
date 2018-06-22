package com.demo.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxy implements MethodInterceptor {

    public Object createProxy(Class targetClass) {

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(targetClass);

        enhancer.setCallback(new CglibDynamicProxy ());

        return enhancer.create();

    }
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Before invoke " + method);

        Object result = proxy.invokeSuper(obj, args);

        System.out.println("After invoke" + method);

        return result;
    }
}
