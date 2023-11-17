package com.silky.pocketbook;

import com.silky.pocketbook.POJO.Pocket;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@MapperScan("com.silky.pocketbook.mapper")
public class PocketBookApplication {
    public static void main(String[] args) {
        SpringApplication.run(PocketBookApplication.class, args);
    }
}
