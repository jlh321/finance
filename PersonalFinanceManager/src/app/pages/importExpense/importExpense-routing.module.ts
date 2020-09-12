import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ImportExpenseComponent } from './importExpense.component';

const routes: Routes = [
  { path: '', component: ImportExpenseComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
   declarations: []
})
export class ImportExpenseRoutingModule { }
