package com.recipeBook.shoppingListRestApi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class ShoppingListModel {
    @Id
    String id;

    String name;
    int amount;

}
