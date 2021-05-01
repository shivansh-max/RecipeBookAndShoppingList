package com.finalApiForTheRecipeAndShoppingList.FinaleRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.models"})
//@EntityScan("com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.models")
//@EnableJpaRepositories("com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.repos")
public class FinaleRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinaleRestApiApplication.class, args);
    }

}
