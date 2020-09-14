import { NgModule } from '@angular/core';
import { NzTableModule } from 'ng-zorro-antd/table'; 
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzModalModule } from 'ng-zorro-antd/modal';
import { NzFormModule } from 'ng-zorro-antd/form';


import { CommonModule } from '@angular/common';
import { ShowExpenseComponent } from './showExpense.component';
import { ShowExpenseRoutingModule } from './showExpense-routing.module';

@NgModule({
  imports: [
    CommonModule,
    ShowExpenseRoutingModule,
    NzTableModule,
    NzButtonModule,
    NzModalModule,
    NzFormModule,
 
  ],
  declarations: [ShowExpenseComponent],
  exports: [ShowExpenseComponent]
})
export class ShowExpenseModule { }
