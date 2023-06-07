package com.example.demo;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

interface Subject {

    void request();

}

class RealSubject implements subject {

    public void request() {
        System.out.println("RealSubject executes request.");
    }

}

class ProxySubject implements subject {

    private subject realSubject;

    public ProxySubject(subject realSubject) {
        this.realSubject = realSubject;
    }

    public void request() {
        System.out.println("Before executing request.");
        realSubject.request();
        System.out.println("After executing request.");
    }

}

public class StaticProxyExample {

    public static void main(String[] args) {
        subject realSubject = new realSubject();
        InvocationHandler dynamicProxy = new DynamicProxy(realSubject);
        subject proxySubject = (subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), dynamicProxy);
        proxySubject.request();
    }
}

