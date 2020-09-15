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
  public category:Category[]=[{
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
 =[{
    "id":1,
    "amount":100,
    "description":"online shopping",
    "date":null,
    "category":this.category[0]


  }];


  constructor(private expenseService:ExpenseService,
              private modal:NzModalService,
              private fb: FormBuilder) { }

  ngOnInit() {
    this.validateForm = this.fb.group({
      datePicker: [null],
    });
    this.getExpenses(0,0,0,0);
  }

  getExpenses(type:number,day:number,month:number,year:number): void {
    this.expenseService.getExpenses(this.expenseService.buildGetUrl(type,day,month,year))
      .subscribe(expenses=>this.expenses=expenses);
  }

  addExpense(amount:number,date:Date,description:string,cat_id:number,cat_name:string): void{
    description=description.trim();
    cat_name=cat_name.trim();

    var expense:Expense = {
      "id":null,
      "amount":amount,
      "date" : date,
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

  delete(expense:Expense){
    this.expenses=this.expenses.filter(e=>e!=expense);
    this.expenseService.deleteExpense(expense).subscribe();
  }

  //for display
  isVisible = false;
  isConfirmLoading = false;
 
  submitForm(): void {
    console.log(this.validateForm.value);
  }
  showModal(): void {
    this.isVisible = true;
  }

  handleOk(): void {
    this.isConfirmLoading = true;
    setTimeout(() => {
      this.isVisible = false;
      this.isConfirmLoading = false;
    }, 3000);
  }

  handleCancel(): void {
    console.log(this.validateForm.value);
    this.isVisible = false;
  }

  showDeleteConfirm(): void {
    this.modal.confirm({
      nzTitle: 'Are you sure delete this task?',
      nzContent: '<b style="color: red;">Some descriptions</b>',
      nzOkText: 'Yes',
      nzOkType: 'danger',
      nzOnOk: () => console.log('OK'),
      nzCancelText: 'No',
      nzOnCancel: () => console.log('Cancel')
    });
  }
}



