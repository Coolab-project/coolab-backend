package com.example.CoolabSpring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.CoolabSpring")
public class BlogBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogBoardApplication.class, args);
	}

}
