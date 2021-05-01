package com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.repos;

import com.finalApiForTheRecipeAndShoppingList.FinaleRestApi.models.ShoppingListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepo extends JpaRepository <ShoppingListModel,String> {
}