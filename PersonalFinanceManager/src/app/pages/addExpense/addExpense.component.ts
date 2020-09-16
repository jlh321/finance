import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Expense } from '../showExpense/expense';
import {Category} from '../category/category';
import {ExpenseService} from '../showExpense/expense.service'

@Component({
  selector: 'app-addExpense',
  templateUrl: './addExpense.component.html',
  styleUrls: ['./addExpense.component.css']
})
export class AddExpenseComponent implements OnInit {
  validateForm!: FormGroup;

  newExpense:Expense={
    "id":null,
    "amount":null,
    "category":null,
    "description":null,
    "day":null,
    "month":null,
    "year":null
  }
  date:Date;
  selectedCategory:Category;
  categories:Category[]=[{
    "id":1,
    "name":"home/rent"
  },
  {
    "id":2,
    "name":"water"
  },
  {
    "id":3,
    "name":"shopping"
  }];;

  constructor(private fb: FormBuilder,
              private expenseService: ExpenseService) { }

  ngOnInit() {
    this.validateForm = this.fb.group({
  
    });
  }


  buildDateString(expense:Expense):string{
    return  new Date(expense.year,expense.month,expense.day).toLocaleDateString();
  }

  buildDate(expense:Expense):Date{
    console.log(expense.month)
    return  new Date(expense.year,expense.month,expense.day);
  }
  addExpense(expense:Expense): void{
    if(!expense){return; }
    this.expenseService.addExpense(expense)
      .subscribe();
  }

  //for display
  submitForm(): void {
    console.log(this.validateForm.value);
    this.newExpense.category=this.selectedCategory;
    this.newExpense.day=this.date.getDay();
    this.newExpense.month=this.date.getMonth();
    this.newExpense.year=this.date.getFullYear();
    console.log("after submit before ADD: "+this.newExpense.category.name+": " +this.newExpense.id);
    this.addExpense(this.newExpense);
    
  }

  onChangeDate(result: Date): void {
    console.log('onChange: ', result);
    console.log('Date: '+this.date);

  }

  onChangeCategory(result: Category): void {
    console.log('onChange: ', result);
    console.log('currentExpense: '+this.newExpense.category.name)
    console.log('selected: '+this.selectedCategory.name)
  }
}
