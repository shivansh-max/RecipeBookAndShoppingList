package com.recipe.recipeRestApi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ProcessedData {

    RecipeModel recipeModel;
    List<Ingrident> ingrident;

}
