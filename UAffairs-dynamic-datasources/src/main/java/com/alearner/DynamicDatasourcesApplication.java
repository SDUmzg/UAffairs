package com.alearner;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableTransactionManagement(order=2)  //设置事务执行顺序(需要在切换数据源之后，否则只走默认库)
@MapperScan(basePackages = "com.alearner.mapper.*")
public class DynamicDatasourcesApplication {

    public static void main(String[]args){
        SpringApplication.run(DynamicDatasourcesApplication.class,args);
    }

}
