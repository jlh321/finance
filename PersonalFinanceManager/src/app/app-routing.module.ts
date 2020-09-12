import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/welcome' },
  { path: 'welcome', loadChildren: () => import('./pages/welcome/welcome.module').then(m => m.WelcomeModule) },
  { path: 'category', loadChildren: () => import('./pages/category/category.module').then(m => m.CategoryModule) },
  { path: 'budget', loadChildren: () => import('./pages/budget/budget.module').then(m => m.BudgetModule) },
  { path: 'showExpense', loadChildren: () => import('./pages/showExpense/showExpense.module').then(m => m.ShowExpenseModule) },
  { path: 'addExpense', loadChildren: () => import('./pages/addExpense/addExpense.module').then(m => m.AddExpenseModule) },
  { path: 'importExpense', loadChildren: () => import('./pages/importExpense/importExpense.module').then(m => m.ImportExpenseModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
