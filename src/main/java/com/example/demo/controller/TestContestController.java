package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.service.StudentService;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestContestController {





    @Autowired
    UserMapper userMapper;
    @Autowired
    StudentService studentService;
    @RequestMapping("hello")
    public  Object getHello(){
        List<Integer> id=new ArrayList<>();
        id.add( 1);
        id.add(2);
        val students = userMapper.selectBatchIds(id);
        return  students;
    }

    @RequestMapping("test")
    public  Object getHelloTest(){
        val nameTwo = studentService.getNameTwo("111");
        return null;

    }
    @RequestMapping("test1")
    public  Object getHelloTest1(){
        val nameTwo = studentService.getNameThree("111");
        return null;

    }




}
