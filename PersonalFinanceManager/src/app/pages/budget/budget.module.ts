import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BudgetComponent } from './budget.component';
import { BudgetRoutingModule } from './budget-routing.module';

@NgModule({
  imports: [
    CommonModule,
    BudgetRoutingModule
  ],
  declarations: [BudgetComponent],
  exports: [BudgetComponent]
})
export class BudgetModule { }
