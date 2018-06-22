package com.demo.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * CGLIB 动态代理
 * 生成的代理类继承了被代理的类
 * 所以无法代理final修饰的方法
 */
public class Client {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\class");
        CglibDynamicProxy cglibDynamicProxy =new CglibDynamicProxy();
        Hello hello =(Hello) cglibDynamicProxy.createProxy(Hello.class);
        System.out.println(hello.getClass());
        hello.sayHello("张三");
    }
}
