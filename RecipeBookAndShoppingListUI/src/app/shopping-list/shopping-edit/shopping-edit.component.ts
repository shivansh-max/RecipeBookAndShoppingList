import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {Subscription} from "rxjs";

import { Ingredient } from '../../shared/ingredient.model';
import { ShoppingListService } from '../shopping-list.service';

@Component({
  selector: 'app-shopping-edit',
  templateUrl: './shopping-edit.component.html',
  styleUrls: ['./shopping-edit.component.css']
})
export class ShoppingEditComponent implements OnInit, OnDestroy {
  @ViewChild('f',{static: true}) form: NgForm;
  sub: Subscription;
  editMode = false;
  editingId: number;
  editingItem: Ingredient;

  constructor(private slService: ShoppingListService) { }

  ngOnInit() {
    this.sub = this.slService.startedEditing
      .subscribe((index: number) => {
        this.editingId = index
        this.editMode=true;
        this.editingItem = this.slService.getIngredient(index)
        this.form.setValue({
          name: this.editingItem.name,
          amount: this.editingItem.amount
        });
      })
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  onSubmit() {
    // console.log(this.form)
    const value =this.form.value;
    const newIngredient = new Ingredient(Math.random().toString(36).substring(2), value.name, value.amount);
    if (this.editMode) {
      this.slService.updateIngredient( this.editingId, newIngredient)
    }else {
      this.slService.addIngredient(newIngredient);
    }
    this.onClear();
  }

  onClear() {
    this.form.reset();
    this.editMode = false;
  }

  onDelete() {
    this.slService.deleteIngredient(this.editingId);
    this.onClear();
  }
}
