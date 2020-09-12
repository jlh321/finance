import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShowExpenseComponent } from './showExpense.component';
import { ShowExpenseRoutingModule } from './showExpense-routing.module';

@NgModule({
  imports: [
    CommonModule,
    ShowExpenseRoutingModule
  ],
  declarations: [ShowExpenseComponent],
  exports: [ShowExpenseComponent]
})
export class ShowExpenseModule { }
