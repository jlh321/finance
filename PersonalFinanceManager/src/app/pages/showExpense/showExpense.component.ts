import { Component, OnInit } from '@angular/core';
import { Expense } from './expense';
import { ExpenseService } from './expense.service';
import {Category} from '../category/category'
import { NzModalService } from 'ng-zorro-antd/modal';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ShowExpenseRoutingModule } from './showExpense-routing.module';


@Component({
  selector: 'app-showExpense',
  templateUrl: './showExpense.component.html',
  styleUrls: ['./showExpense.component.css']
})
export class ShowExpenseComponent implements OnInit {

  validateForm!: FormGroup;
  isVisible = false;
  isConfirmLoading = false;
  currentExpense:Expense;
  selectedCategory:Category;
  date: Date;

  //call api categories
  public categories:Category[]=[{
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
  }];
  public expenses:Expense[]



  constructor(private expenseService:ExpenseService,
              private modal:NzModalService,
              private fb: FormBuilder) { }

  ngOnInit() {
    this.validateForm = this.fb.group({
      datePicker: [null],
    });
    this.getExpenses(2,0,9,2020);
  }


  getExpenses(type:number,day:number,month:number,year:number): void {
    console.log("type:"+type+"  month:"+month);
    var url=this.expenseService.buildGetUrl(type,day,month,year);
    console.log(url);
    this.expenseService.getExpenses(url)
      .subscribe(expenses=>this.expenses=expenses);
  }

  
  addExpense(amount:number,date:Date,description:string,cat_id:number,cat_name:string): void{
    description=description.trim();
    cat_name=cat_name.trim();

    var expense:Expense = {
      "id":null,
      "amount":amount,
      "day":date.getDay(),
      "month":date.getMonth(),
      "year":date.getFullYear(),
      "description" : description,
      "category" : {
        "id" : cat_id,
        "name":cat_name
      }
    }

    if(!expense){return; }
    this.expenseService.addExpense(expense)
      .subscribe(expense=>
      this.expenses.push(expense));
  }

  updateExpense(expense:Expense): void {
    this.expenses=this.expenses.filter(e=>e.id!=expense.id);
    this.expenses.push(expense);
    this.expenseService.updateExpense(expense)
      .subscribe();
  }

  deleteExpense(expense:Expense){
    this.expenses=this.expenses.filter(e=>e!=expense);
    this.expenseService.deleteExpense(expense.id).subscribe(
      // res=>this.expenses.filter(e=>e!=expense),
      // error=>console.log(error)
    );
  }

  buildDateString(expense:Expense):string{
    return  new Date(expense.year,expense.month,expense.day).toLocaleDateString();
  }

  buildDate(expense:Expense):Date{
    console.log(expense.month)
    return  new Date(expense.year,expense.month,expense.day);
  }

  //for display
  submitForm(): void {
    console.log(this.validateForm.value);
    this.isVisible = false;
    this.currentExpense.category=this.selectedCategory;
    this.currentExpense.day=this.date.getDay();
    this.currentExpense.month=this.date.getMonth();
    this.currentExpense.year=this.date.getFullYear();
    console.log("after submit before update: "+this.currentExpense.category.name+": " +this.currentExpense.id);
    var expense: Expense=this.currentExpense;
    this.updateExpense(expense);
    
  }

  showDeleteConfirm(expense:Expense): void {
    this.modal.confirm({
      nzTitle: 'Are you sure delete this task?',
      nzOkText: 'Yes',
      nzOkType: 'danger',
      nzOnOk: () => {
        console.log('OK')
        this.deleteExpense(expense);
      },
      nzCancelText: 'No',
      nzOnCancel: () => console.log('Cancel')
    });
  }

  openModal(currentExpense:Expense):void{
    this.isVisible=true;
    this.currentExpense=currentExpense;
    this.selectedCategory=currentExpense.category;
    console.log("open:" + this.selectedCategory);
    this.date=this.buildDate(currentExpense);
  }
  handleOk(): void {
    this.isVisible = true;
  }

  handleCancel(): void {
    this.isVisible = false;
  }

  onChangeDate(result: Date): void {
    console.log('onChange: ', result);
    console.log('Date: '+this.date);

  }

  onChangeCategory(result: Category): void {
    console.log('onChange: ', result);
    console.log('currentExpense: '+this.currentExpense.category.name)
    console.log('selected: '+this.selectedCategory.name)
  }
}



