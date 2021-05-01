package com.recipe.recipeRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")

public class RecipeRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeRestApiApplication.class, args);
	}

}
