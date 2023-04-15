package com.fudy.itemdetail;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.fudy.itemdetail.infrastructure.mybatis.mapper")
@SpringBootApplication
public class FudyShopItemDetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(FudyShopItemDetailApplication.class, args);
	}

}
