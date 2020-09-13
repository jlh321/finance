import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BudgetComponent } from './budget.component';
import { BudgetRoutingModule } from './budget-routing.module';
import { NzDatePickerModule } from 'ng-zorro-antd/date-picker';
import {FormsModule} from '@angular/forms';
import { NzTableModule } from 'ng-zorro-antd/table';

@NgModule({
  imports: [
    CommonModule,
    BudgetRoutingModule,
    NzDatePickerModule,
    FormsModule,
    NzTableModule
  ],
  declarations: [BudgetComponent],
  exports: [BudgetComponent]
})
export class BudgetModule { 

}
