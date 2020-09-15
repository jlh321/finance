import { NgModule } from '@angular/core';
import { NzTableModule } from 'ng-zorro-antd/table'; 
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzModalModule } from 'ng-zorro-antd/modal';
import { NzFormModule } from 'ng-zorro-antd/form';
import { FormBuilder } from '@angular/forms';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';


import { CommonModule } from '@angular/common';
import { AddExpenseComponent } from './addExpense.component';
import { AddExpenseRoutingModule } from './addExpense-routing.module';

@NgModule({
  imports: [
    CommonModule,
    AddExpenseRoutingModule,
    NzTableModule,
    NzButtonModule,
    NzModalModule,
    NzFormModule,
    ReactiveFormsModule,
    FormsModule,
 
  ],
  declarations: [AddExpenseComponent],
  exports: [AddExpenseComponent],
  providers:[FormBuilder]
})
export class AddExpenseModule { }
