package com.example.demo;

import com.example.demo.domain.po.User;

public class Test11 {
    public static void main(String[] args) {

        User user=User.builder().name("范旺").age(100).email("1109499343@qq.com").build();
         user.toBuilder().email("111").build();
        System.out.println(user.getEmail());
        System.out.println(user.getEmail());
    }
}
