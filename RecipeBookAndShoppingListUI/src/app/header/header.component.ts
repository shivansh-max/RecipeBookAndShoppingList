import {Component, EventEmitter, OnDestroy, OnInit, Output} from '@angular/core';
import {RecipesDataManegerService} from "../shared/recipes-data-maneger.service";
import {Recipe} from "../recipes/recipe.model";
import {SharingService} from "../shared/sharing.service";
import {RecipeService} from "../recipes/recipe.service";

import {getOuterNodeFromInnerDeclaration} from "@angular/compiler-cli/ngcc/src/host/esm2015_host";
import {Ingredient} from "../shared/ingredient.model";
import {ShoppingListService} from "../shopping-list/shopping-list.service";
import {ShoppingListDataManegerService} from "../shared/shopping-list-data-maneger.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent implements OnInit, OnDestroy {
  recipes: Recipe[] = [];
  origingalRecipes: Recipe[] = [];

  shoppingList: Ingredient[] = [];
  origingalShoppingList: Ingredient[] = [];

  constructor(
    private recipeDataStore: RecipesDataManegerService,
    private shoppingDataService: ShoppingListDataManegerService,
    private recipeService: RecipeService,
    private shoppingService: ShoppingListService
    ) {

  }

  ngOnInit(): void {
    this.getData();
    this.recipeDataStore.getAllRecipes().subscribe((recipesArray: Recipe[]) => {
      console.log("Recipes Array : ")
      console.log(recipesArray)
      this.origingalRecipes = recipesArray;
      console.log("Original Recipes : ")
      console.log(this.origingalRecipes)
    });
  }

  getData() {
    this.recipeDataStore.getAllRecipes().subscribe((recipeArray) => {
      this.recipes = recipeArray
      this.recipeService.setterForRecipes(this.recipes)
    });
    this.shoppingDataService.getAllItems().subscribe((itemsArray) => {
      console.log(itemsArray)
      this.shoppingList = itemsArray
      console.log(this.shoppingList)
      this.shoppingService.setterForIngredients(this.shoppingList)
    });
  }

  saveData() {
    //Recipes

    this.recipeDataStore.getAllRecipes().subscribe((recipeArray) => {
      console.log(recipeArray)
      this.origingalRecipes = recipeArray
      console.log(this.origingalRecipes)
    });

    let recipes: Recipe[] = this.recipeService.getRecipes();

    for (let recipe of this.origingalRecipes) {
      this.recipeDataStore.deleteRecipe(recipe).subscribe();
    };

    for (let recipe of this.recipeService.getRecipes()) {
      this.recipeDataStore.addNewRecipe(recipe).subscribe();
    };

    //Shopping List

    this.shoppingDataService.getAllItems().subscribe((ingredientsArray) => {
      this.origingalShoppingList = ingredientsArray
    });

    let shoppinglist: Ingredient[] = this.shoppingService.getIngredients();
    console.log(this.shoppingDataService)
    for (let ingredient of this.origingalShoppingList) {
      this.shoppingDataService.deleteShoppingListItem(ingredient).subscribe();
    };

    for (let ingredient of this.shoppingList) {
      this.shoppingDataService.addNewItemToTheShoppingList(ingredient).subscribe();
    };

  }

  ngOnDestroy(): void {
    this.saveData();
  }
}
