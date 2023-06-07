package com.example.demo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("student")
public class Student {

    private  Integer    id;
    private  String     name;
    private  String     school;
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp   creatTime;

    public String sayHello(){
        System.out.println("你好世界");
        return "你好";
    }

}
