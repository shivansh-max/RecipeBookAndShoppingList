package com.recipeBook.shoppingListRestApi.repos;

import com.recipeBook.shoppingListRestApi.models.ShoppingListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepo extends JpaRepository <ShoppingListModel,String> {
}
