package com.example.demo;

import java.lang.reflect.Field;

public class SerializationExample {

    public static void main(String[] args) {
        // 创建一个对象
        Person person = new Person("LeetCoder", 22);

        // 序列化对象
        String serialized = serialize(person);
        System.out.println("序列化结果：" + serialized);

        // 反序列化对象
        Person deserialized = deserialize(serialized, Person.class);
        System.out.println("反序列化结果：" + deserialized);
    }

    // 序列化方法
    public static <T> String serialize(T obj) {
        StringBuilder stringBuilder = new StringBuilder();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                stringBuilder.append(field.getName()).append("=").append(field.get(obj)).append(",");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    // 反序列化方法
    public static <T> T deserialize(String str, Class<T> cls) {
        try {
            String[] parts = str.split(",");
            T obj = cls.newInstance();
            for (String part : parts) {
                String[] kv = part.split("=");
                Field field = cls.getDeclaredField(kv[0]);
                field.setAccessible(true);
                setValue(field, obj, kv[1]);
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 根据属性类型设置属性值
    private static void setValue(Field field, Object obj, String value) throws Exception {
        if (field.getType() == int.class) {
            field.setInt(obj, Integer.parseInt(value));
        } else if (field.getType() == String.class) {
            field.set(obj, value);
        }
        // 其他类型同理，可以根据实际情况进行扩展
    }
}

class Person {

    private String name;

    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Person{name=" + name + ", age=" + age + "}";
    }

}
