package com.wulian.tkmybatis;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.wulian.tkmybatis")
@MapperScan("com.wulian.tkmybatis.mapper")
public class TkmybatisApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(TkmybatisApp.class).run(args);
    }

}
