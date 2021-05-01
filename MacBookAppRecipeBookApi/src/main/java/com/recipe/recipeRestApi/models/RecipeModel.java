package com.recipe.recipeRestApi.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class RecipeModel {
    @Id
    String id;

    String recipe_name;
    String image_path;
    String recipe_description;
    String name_of_ingredient;
    String amount_of_ing;

}
