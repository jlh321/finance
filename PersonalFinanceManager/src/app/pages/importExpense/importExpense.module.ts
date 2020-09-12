import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImportExpenseComponent } from './importExpense.component';
import { ImportExpenseRoutingModule } from './importExpense-routing.module';

@NgModule({
  imports: [
    CommonModule,
    ImportExpenseRoutingModule
  ],
  declarations: [ImportExpenseComponent],
  exports: [ImportExpenseComponent]
})
export class ImportExpenseModule { }
