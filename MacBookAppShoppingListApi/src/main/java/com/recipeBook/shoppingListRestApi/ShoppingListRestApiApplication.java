package com.recipeBook.shoppingListRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.recipeBook.shoppingListRestApi")
public class ShoppingListRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingListRestApiApplication.class, args);
	}

}
