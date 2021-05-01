package com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.repos;


import com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.models.RecipeModel;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
@Configuration
@ResponseBody
public interface RecipeRepo extends JpaRepository <RecipeModel, String> {
}
