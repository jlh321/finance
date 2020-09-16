import { NgModule } from '@angular/core';
import { NzTableModule } from 'ng-zorro-antd/table'; 
import { NzButtonModule } from 'ng-zorro-antd/button';

import { NzFormModule } from 'ng-zorro-antd/form';
import { FormBuilder } from '@angular/forms';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ShowExpenseComponent } from './showExpense.component';
import { ShowExpenseRoutingModule } from './showExpense-routing.module';
import { NzDrawerModule } from 'ng-zorro-antd/drawer';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzModalModule } from 'ng-zorro-antd/modal';
import { NzDatePickerModule } from 'ng-zorro-antd/date-picker';
import { NzSelectModule } from 'ng-zorro-antd/select';
import { NzPageHeaderModule } from 'ng-zorro-antd/page-header';

@NgModule({
  imports: [
    CommonModule,
    ShowExpenseRoutingModule,
    NzTableModule,
    NzButtonModule,
    NzModalModule,
    NzFormModule,
    ReactiveFormsModule,
    FormsModule,
    NzDrawerModule,
    NzDatePickerModule,
    NzInputModule,
    NzSelectModule,
    NzPageHeaderModule
  ],
  declarations: [ShowExpenseComponent],
  exports: [ShowExpenseComponent],
  providers:[FormBuilder]
})
export class ShowExpenseModule { }
