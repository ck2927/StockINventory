package com.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockInventoryApplication {

	public static void main(String[] args) {
		System.out.println("started ...");
		SpringApplication.run(StockInventoryApplication.class, args);
	}

}
