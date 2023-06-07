package com.example.demo;

import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Handle implements Runnable {

    private ThreadLocal<Connection> threadLocal;
    private Connection connection;

    public Handle(ThreadLocal<Connection> threadLocal) {
        this.threadLocal = threadLocal;
    }

    public void handle(String sql) {
        connection = threadLocal.get();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.execute();
            //处理数据

        } catch (Exception e) {

        } finally {
            try {
                connection.close(); //此处不能关闭连接，否则会抛出异常。
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        String sql = "xxxxxx";
        handle(sql);
    }

}
