import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BudgetComponent } from './budget.component';
import { BudgetRoutingModule } from './budget-routing.module';
import { NzDatePickerModule } from 'ng-zorro-antd/date-picker';
import {FormsModule} from '@angular/forms';
import { NzTableModule } from 'ng-zorro-antd/table';
import { DatePipe } from '@angular/common';
import { NzModalModule } from 'ng-zorro-antd/modal';
import { NzInputModule } from 'ng-zorro-antd/input';

@NgModule({
  imports: [
    CommonModule,
    BudgetRoutingModule,
    NzDatePickerModule,
    FormsModule,
    NzTableModule,
    NzModalModule,
    NzInputModule
  ],
  providers: [DatePipe],
  declarations: [BudgetComponent],
  exports: [BudgetComponent]
})
export class BudgetModule { 

}
