package com.example.demo.domain;

import com.example.demo.mapper.UserMapper;
import net.javacrumbs.shedlock.core.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Random;

@Component
public class ScheduledTest {

    @Autowired
    UserMapper userMapper;

    Logger logger= LoggerFactory.getLogger(ScheduledTest.class);

    //每30秒执行一次
    //@Scheduled(cron = "0/30 * * * * ? ")
    //@SchedulerLock(name = "test", lockAtMostForString = "PT10S", lockAtLeastForString = "PT10S")
    public void test() {
        LocalDateTime localDateTime=LocalDateTime.now();
        logger.info("第一个定时任务开始执行 当前时间"+localDateTime);
        System.out.println("定时任务");
    }


    //往数据库里插数据
    //@Scheduled(cron = "0 */1 * * * *")
   // @SchedulerLock(name = "test2", lockAtMostForString = "PT10S", lockAtLeastForString = "PT10S")
    public void test2() {

        LocalDateTime localDateTime=LocalDateTime.now();
        logger.info("第二定时任务开始执行当前时间"+localDateTime);
        Student student=new Student();

        Random rand = new Random();
        int temp = rand.nextInt(1000);
        student.setId(temp);
        student.setName("111");
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        student.setCreatTime(timestamp);
        student.setSchool("222");
        Object o= userMapper.insert(student);
        System.out.println( o);


    }

}
