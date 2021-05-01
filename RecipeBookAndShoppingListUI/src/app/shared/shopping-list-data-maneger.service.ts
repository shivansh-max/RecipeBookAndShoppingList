import { Injectable } from '@angular/core';
import { Ingredient } from './ingredient.model';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Recipe } from '../recipes/recipe.model';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class ShoppingListDataManegerService {
  restApis = environment;

  constructor(private http: HttpClient) {}

  addNewItemToTheShoppingList(ingredient: Ingredient) {
    var post_json = {
      id: ingredient.id,
      name: ingredient.name,
      amount: ingredient.amount,
    };
    return this.http.post(
      this.restApis.shoppingListRestApiUrl + 'additem/',
      post_json
    );
  }

  deleteShoppingListItem(ingredient: Ingredient) {
    return this.http.delete(
      environment.shoppingListRestApiUrl + 'deleteitem/' + ingredient.id
    );
  }

  getAllItems() {
    return this.http
      .get(environment.shoppingListRestApiUrl + 'shoppinglist/')
      .pipe(
        map((dItems) => {
          let items: Ingredient[] = [];
          for (let ingredient in dItems) {
            items.push(
              new Ingredient(
                dItems[ingredient]['id'],
                dItems[ingredient]['name'],
                dItems[ingredient]['amount']
              )
            );
          }
          return items;
        })
      );
  }
}
