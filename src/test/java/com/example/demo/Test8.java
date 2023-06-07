package com.example.demo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class Test8 {
    public static void main(String[] args) {

        Object obj = "" ; // 待转换的 Object
        Set<Object> set = new HashSet<>(Arrays.asList(obj));



        List<MyObject> list = Arrays.asList(
                        new MyObject("John", 25),
                        new MyObject("Mary", 22),
                        new MyObject("Tom", 25),
                        new MyObject("Mary", 22));

                System.out.println(set);
            }
        }

        class MyObject {
            private String name;
            private int age;

            public MyObject(String name, int age) {
                this.name = name;


            }




    public static HashMap<String, Object> objectToHashMap(Object obj) {
        Gson gson = new Gson();
        String json = gson.toJson(obj); // 将 Object 转换为 Json 字符串
        Type type = new TypeToken<HashMap<String, Object>>(){}.getType();
        HashMap<String, Object> hashMap = gson.fromJson(json, type); // 将 Json 字符串转换为 HashMap
        return hashMap;
    }
}
