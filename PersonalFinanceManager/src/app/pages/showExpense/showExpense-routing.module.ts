import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShowExpenseComponent } from './showExpense.component';

const routes: Routes = [
  { path: '', component: ShowExpenseComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
   declarations: []
})
export class ShowExpenseRoutingModule { }
