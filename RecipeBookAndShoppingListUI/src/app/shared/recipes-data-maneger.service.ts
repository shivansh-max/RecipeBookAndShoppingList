import {Injectable} from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Recipe} from "../recipes/recipe.model";
import {map} from "rxjs/operators";
import {Ingredient} from "./ingredient.model";

@Injectable({
  providedIn: 'root'
})
export class RecipesDataManegerService {
  restApis = environment

  public recipesList: Recipe[] = []

  constructor(private http: HttpClient) {
  }

  //Recipe

  addNewRecipe(recipe: Recipe) {
    let names: string;
    let amount: string;

    names = ""
    amount = ""

    let indi: number;
    for (let i of recipe.ingredients) {
      indi += 1;
      if (indi < recipe.ingredients.length ) {
        amount += i.amount
        names += i.name
      } else {
        names += i.name
        amount += i.amount
        names += ","
        amount += ","
      }
    }

    // console.log(names)
    //
    // console.log(amount)

    let stri = Math.random().toString(36).substring(2)
    var post_json = {
      "id": stri,
      "recipe_name": recipe.name,
      "image_path": recipe.imagePath,
      "recipe_description": recipe.description,
      "name_of_ingredient": names,
      "amount_of_ing": amount
    };

    // console.log(post_json)
    return this.http.post(environment.recipeRestApiUrl + "addrecipe/", post_json);
  }

  deleteRecipe(reicpe: Recipe) {
    // console.log(reicpe.id)
    console.log(environment.recipeRestApiUrl + "deleterecipe/" + reicpe.id)
    return this.http.delete(environment.recipeRestApiUrl + "deleterecipe/" + reicpe.id);
  }

  getAllRecipes() {
    return this.http.get(environment.recipeRestApiUrl + "allrecipes/").pipe(
      map((posts) => {
          let recipeArray: Recipe[] = [];
          for (let key in posts) {
            let ingredients: Ingredient[] = [];
            for (let ingredient of posts[key]["ingrident"]) {
              ingredients.push(
                new Ingredient(
                  Math.random().toString(36).substring(2),
                  ingredient.recipeName,
                  ingredient.qty
                )
              )
            }
            recipeArray.push(
              new Recipe(
                posts[key]["recipeModel"].id,
                posts[key]["recipeModel"].recipe_name,
                posts[key]["recipeModel"].recipe_description,
                posts[key]["recipeModel"].image_path,
                ingredients)
            )
            // console.log(recipeArray)
          }
        return recipeArray;
        }
      )
    );
  }

  // editRecipe(recipe: Recipe, newRecipe: Recipe) {
  //   this.deleteRecipe(recipe.id);
  //   recipe.name = newRecipe.name;
  //   recipe.description = newRecipe.description;
  //   recipe.imagePath = recipe.imagePath;
  //   recipe.ingredients = newRecipe.ingredients;
  //   this.addNewRecipe(recipe);
  // }

}
