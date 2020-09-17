import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Expense } from '../showExpense/expense';
import {Category} from '../category/category';
import {ExpenseService} from '../showExpense/expense.service'
import { NzModalService } from 'ng-zorro-antd/modal';

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
  // categories:Category[]=[{
  //   "id":"5f61d18349a55832271dd89b",
  //   "name":"Car Payments"
  // }];;
  categories:Category[];
  constructor(private fb: FormBuilder,
              private expenseService: ExpenseService,
              private modalService: NzModalService) { }

  ngOnInit() {
    this.validateForm = this.fb.group({
  
    });
    this.getCategories();
  }


  buildDateString(expense:Expense):string{
    console.log("datetostring:"+new Date(expense.year,expense.month-1,expense.day).toLocaleDateString());
    return  new Date(expense.year,expense.month-1,expense.day).toLocaleDateString();
  }

  buildDate(expense:Expense):Date{
    console.log(expense.month)
    return  new Date(expense.year,expense.month,expense.day);
  }
  addExpense(expense:Expense): void{
    if(!expense){return; }
    this.expenseService.addExpense(expense)
      .subscribe(
        res=>console.log(res)
      );
  }

  getCategories():void{
    var url="api/category";
    this.expenseService.getCategories(url)
      .subscribe(categories=>this.categories=categories);
  }
  //for display
  submitForm(): void {
    console.log(this.validateForm.value);
    this.newExpense.category=this.selectedCategory;
    console.log("day:"+this.date);
    console.log("day:"+this.date.getDate());
    console.log("month:"+(this.date.getMonth()+1));
    console.log("year:"+this.date.getFullYear());
    this.newExpense.day=this.date.getDate();
    this.newExpense.month=this.date.getMonth()+1;
    this.newExpense.year=this.date.getFullYear();
    console.log("after submit before ADD: "+this.newExpense.category.name+": " +this.newExpense.id);
    this.addExpense(this.newExpense);
    this.submitSuccess();
    
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

  submitSuccess(): void {
    const modal = this.modalService.success({
      nzTitle: 'Submit notification message',
      nzContent: 'Submit Successful',
      nzOkText: 'Ok'
    });

    setTimeout(() => modal.destroy(), 3000);
  }
}
