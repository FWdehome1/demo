package com.example.demo;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface subject {

    void request();

}

class realSubject implements subject {

    public void request() {
        System.out.println("RealSubject executes request.");
    }

}

class DynamicProxy implements InvocationHandler {

    private Object subject;

    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before executing request.");
        Object result = method.invoke(subject, args);
        System.out.println("After executing request.");
        return result;
    }

}

public class DynamicProxyExample {

    public static void main(String[] args) {
        subject realSubject = new realSubject();
        InvocationHandler dynamicProxy = new DynamicProxy(realSubject);
        subject proxySubject = (subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), dynamicProxy);
        proxySubject.request();
    }

}

