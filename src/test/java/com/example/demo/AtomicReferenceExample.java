package com.example.demo;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceExample {

    public static void main(String[] args) {
        AtomicReference<String> atomicReference = new AtomicReference<>("initialValue");

        // 获取当前值
        String currentValue = atomicReference.get();
        System.out.println("Current value: " + currentValue);

        // 尝试更新值，如果当前值等于期望值则更新成功
        boolean updated = atomicReference.compareAndSet("initialValue", "newValue");
        System.out.println("Update successful: " + updated);
        System.out.println("Current value: " + atomicReference.get());

        // 尝试更新值，期望值不匹配则更新失败
        updated = atomicReference.compareAndSet("initialValue", "newValue");
        System.out.println("Update successful: " + updated);
        System.out.println("Current value: " + atomicReference.get());

        // 设置新值
        atomicReference.set("newInitialValue");
        System.out.println("Current value: " + atomicReference.get());
    }
}

