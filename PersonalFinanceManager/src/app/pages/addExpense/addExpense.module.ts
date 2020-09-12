import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddExpenseComponent } from './addExpense.component';
import { AddExpenseRoutingModule } from './addExpense-routing.module';

@NgModule({
  imports: [
    CommonModule,
    AddExpenseRoutingModule
  ],
  declarations: [AddExpenseComponent],
  exports: [AddExpenseComponent]
})
export class AddExpenseModule { }
