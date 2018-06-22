package com.demo.proxy.jdk;

public class RealSubject implements Subject {
    final public void rent() {
        System.out.println("I want to rent my house");
    }

    public void hello(String str) {
        System.out.println("hello: " + str);
    }
}