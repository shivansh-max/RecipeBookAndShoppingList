import {Recipe} from './recipe.model';
import {Ingredient} from '../shared/ingredient.model';
import {ShoppingListService} from '../shopping-list/shopping-list.service';
// import {Subject} from "rxjs";
import {Injectable, OnDestroy, OnInit} from "@angular/core";
import {interval, Observable, Subject, Subscription} from 'rxjs';
import {RecipesDataManegerService} from "../shared/recipes-data-maneger.service";
import {ShoppingListDataManegerService} from "../shared/shopping-list-data-maneger.service";
import {HeaderComponent} from "../header/header.component";
import {SharingService} from "../shared/sharing.service";

@Injectable()
export class RecipeService implements OnInit, OnDestroy {

  public recipesChanged = new Subject<Recipe[]>();

  public recipes: Recipe[] = [];

  ngOnit() {
    this.recipesChanged.next(this.recipes.slice())
  }

  constructor(
    private slService: ShoppingListService,
    private recipeDataStorerService: RecipesDataManegerService,
    private shoppingListStorerService: ShoppingListDataManegerService) {
  }

  setterForRecipes(recipes: Recipe[]) {
    this.recipes = recipes;
    this.recipesChanged.next(this.recipes.slice());
  }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {

  }

  getRecipes() {
    return this.recipes.slice();
  }

  getRecipe(id: number) {
    return this.recipes[id]
  }

  addIngredientsToShoppingList(ingredients: Ingredient[]) {
    this.slService.addIngredients(ingredients);
  }

  addRecipe(recipe: Recipe) {
    // console.log(recipe)
    let newRecipe: Recipe = new Recipe(
      Math.random().toString(36).substring(2),
      recipe.name,
      recipe.description,
      recipe.imagePath,
      recipe.ingredients
  )
    this.recipes.push(newRecipe)
    this.recipesChanged.next(this.recipes.slice());
  }

  updateRecipe(recipe: Recipe, index: number) {
    this.recipes[index] = recipe;
    this.recipesChanged.next(this.recipes.slice());
  }

  deleteRecipe(index: number) {
    this.recipes.splice(index, 1)
    this.recipesChanged.next(this.recipes.slice());
  }
}
