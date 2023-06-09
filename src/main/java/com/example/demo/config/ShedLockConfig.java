package com.example.demo.config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.spring.ScheduledLockConfiguration;
import net.javacrumbs.shedlock.spring.ScheduledLockConfigurationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.Duration;

@Component
public class ShedLockConfig {

    @Bean
    public LockProvider lockProvider(DataSource dataSource) {

        // 导入所需的类和包


// 构造数据源对象
        DriverManagerDataSource dataSource2 = new DriverManagerDataSource();
        dataSource2.setDriverClassName("org.postgresql.Driver");
        dataSource2.setUrl("jdbc:mysql://localhost:3306/my_test?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        dataSource2.setUsername("root");
        dataSource2.setPassword("123456");

/*// 创建JdbcLockRegistry对象
        JdbcLockRegistryFactoryBean factory = new JdbcLockRegistryFactoryBean();
        factory.setDataSource(dataSource); // 设置数据源
        JdbcLockRegistry registry = factory.getObject();*/


        return new JdbcTemplateLockProvider(dataSource);
    }

    @Bean
    public ScheduledLockConfiguration scheduledLockConfiguration(LockProvider lockProvider) {
        return ScheduledLockConfigurationBuilder.withLockProvider(lockProvider)
                .withPoolSize(10)
                .withDefaultLockAtMostFor(Duration.ofMinutes(10))
                .build();
    }

}
