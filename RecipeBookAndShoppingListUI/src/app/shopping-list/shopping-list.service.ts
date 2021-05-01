// import { EventEmitter } from '@angular/core';
export class ShoppingListService {
  ingredientsChanged = new Subject<Ingredient[]>();
  startedEditing = new Subject<number>();

  private ingredients: Ingredient[] = [
  ];

  setterForIngredients (ingredients :Ingredient[]) {
    this.ingredients = ingredients
    console.log(this.ingredients)
    this.ingredientsChanged.next(this.ingredients.slice());
  }

  getIngredients() {
    return this.ingredients.slice();
  }

  addIngredient(ingredient: Ingredient) {
    this.ingredients.push(ingredient);
    this.ingredientsChanged.next(this.ingredients.slice());
  }

  getIngredient(id:number){
    return this.ingredients[id];
  }

  addIngredients(ingredients: Ingredient[]) {
    // for (let ingredient of ingredients) {
    //   this.addIngredient(ingredient);
    // }
    this.ingredients.push(...ingredients);
    this.ingredientsChanged.next(this.ingredients.slice());
  }

  updateIngredient(index:number, ingredient:Ingredient) {
    this.ingredients[index] = ingredient;
    this.ingredientsChanged.next(this.ingredients.slice())
  }

  deleteIngredient(index:number) {
    this.ingredients.splice(index, 1);
    // console.log(this.ingredients)
    this.ingredientsChanged.next(this.ingredients.slice());
  }
}
import { Ingredient } from '../shared/ingredient.model';

import { Subject } from 'rxjs';
