import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImportExpenseComponent } from './importExpense.component';
import { ImportExpenseRoutingModule } from './importExpense-routing.module';

import { NzTableModule } from 'ng-zorro-antd/table'; 
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzFormModule } from 'ng-zorro-antd/form';
import { FormBuilder } from '@angular/forms';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzModalModule } from 'ng-zorro-antd/modal';
import { NzDatePickerModule } from 'ng-zorro-antd/date-picker';
import { NzSelectModule } from 'ng-zorro-antd/select';
import { NzPageHeaderModule } from 'ng-zorro-antd/page-header';

@NgModule({
  imports: [
    CommonModule,
    ImportExpenseRoutingModule,
    NzTableModule,
    NzButtonModule,
    NzModalModule,
    NzFormModule,
    ReactiveFormsModule,
    FormsModule,
    NzDatePickerModule,
    NzInputModule,
    NzSelectModule,
    NzPageHeaderModule
  ],
  declarations: [ImportExpenseComponent],
  exports: [ImportExpenseComponent],
  providers:[FormBuilder]
})
export class ImportExpenseModule { }
