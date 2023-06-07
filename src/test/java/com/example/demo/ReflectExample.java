package com.example.demo;



import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectExample {

    public static void main(String[] args) throws Exception {
        // 获取 Person 类的 Class 对象
        Class<?> personClass = Class.forName("com.example.demo.domain.Student");

        // 创建一个 Person 实例
        Object personObj = personClass.newInstance();

        // 获取 Person 类的 name 属性
        Field nameField = personClass.getDeclaredField("name");
        nameField.setAccessible(true);

        // 设置 Person 实例的 name 属性为 "Alice"
        nameField.set(personObj, "Alice");

        // 获取 Person 类的 sayHello() 方法
        Method sayHelloMethod = personClass.getDeclaredMethod("sayHello");
        sayHelloMethod.setAccessible(true);

        // 调用 Person 实例的 sayHello() 方法
        sayHelloMethod.invoke(personObj);
    }

}

