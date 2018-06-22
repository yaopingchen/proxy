package com.demo.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 * 只支持接口
 * 因为生成的代理类已经继承了Proxy了，java只支持单继承
 */
public class Client {
    public static void main(String[] args) {
        //被代理的接口类
        Subject subject=new RealSubject();
        //动态代理类
        InvocationHandler proxy=new MyJdkDynamicProxy(subject);
        /**
         * 生成的代理类$Proxy0
         * 其中$Proxy0  extends Proxy implements Subject
         * $Proxy0 中生成了 Subject接口的代理方法
         * 代理方法实现： super.h.invoke(this, m3, new Object[]{var1}); 调用的是动态代理的invoke方法
         */
        Subject proxyClass=(Subject) Proxy.newProxyInstance(proxy.getClass().getClassLoader(),subject.getClass().getInterfaces(),proxy);
        System.out.println(proxyClass.getClass());
        proxyClass.rent();
    }
}
