import { Injectable } from '@angular/core';
import {Recipe} from "../recipes/recipe.model";

@Injectable({
  providedIn: 'root'
})
export class SharingService {

  recipes: Recipe[] = [];

  constructor() { }

  seter(recipes: Recipe[]) {
    this.recipes = recipes
  }

  geter(): Recipe[] {
    return  this.recipes;
  }
}
