import { Component, OnInit } from '@angular/core';
import { Expense } from './expense';
import { ExpenseService } from './expense.service';
import {Category} from '../category/category'
import { NzModalService } from 'ng-zorro-antd/modal';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-showExpense',
  templateUrl: './showExpense.component.html',
  styleUrls: ['./showExpense.component.css']
})
export class ShowExpenseComponent implements OnInit {

  validateForm!: FormGroup;
  isVisible = false;
  isConfirmLoading = false;
  // public category:Category[]=[{
  //   "id":1,
  //   "name":"home/rent"
  // },
  // {
  //   "id":2,
  //   "name":"water"
  // },
  // {
  //   "id":3,
  //   "name":"shopping"
  // }];
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

   buildDate(expense:Expense):string{
    //console.log(new Date(expense.year,expense.month,expense.day));
     return  new Date(expense.year,expense.month,expense.day).toLocaleDateString();
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
    this.expenses=this.expenses.filter(e=>e!=expense);
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

  //for display
 
  submitForm(): void {
    console.log(this.validateForm.value);
    //this.updateExpense();
    this.closeDrawer();
  }

  showDeleteConfirm(expense:Expense): void {
    this.modal.confirm({
      nzTitle: 'Are you sure delete this task?',
      //nzContent: '<b style="color: red;">Are you sure delete this task?</b>',
      nzOkText: 'Yes',
      nzOkType: 'danger',
      nzOnOk: () => {
        console.log('OK')
        this.deleteExpense(expense);
      },
      nzCancelText: 'No',
      nzOnCancel: () => console.log('Cancel')
    });
    //this.deleteExpense(expense);

  }

  openDrawer(): void {
    this.isVisible = true;
  }

  closeDrawer(): void {
    this.isVisible = false;
  }
}



