package com.example.demo.domain.po;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class User {
    private String  name;
    private String  email;
    private Integer  age;
}
