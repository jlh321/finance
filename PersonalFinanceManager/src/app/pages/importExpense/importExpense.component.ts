import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

import {Account} from './Account';
import {AccountTransaction} from './AccountTransaction';
import { AccountTransactionServiceService} from './account-transaction-service.service';
import {ExpenseService} from '../showExpense/expense.service';
import {Category} from '../category/category';
import {Expense} from '../showExpense/expense'

@Component({
  selector: 'app-importExpense',
  templateUrl: './importExpense.component.html',
  styleUrls: ['./importExpense.component.css']
})
export class ImportExpenseComponent implements OnInit {


  account:Account={
    "id":"1",
    "name":"Ali Pay"
  }
  transactions:AccountTransaction[]=[{
    "id": "1234",
    "amount": 1400,
    "year":2020,
    "month":9,
    "day":8,
    "description": "haha",
    "account": this.account 
  }]
  validateForm!: FormGroup;
  categories:Category[];
  selectedCategory:Category;
  selectedTransaction:AccountTransaction;
  isVisible=false;
  isDisable=false;

  constructor(private fb: FormBuilder,
              private accountTransactionService: AccountTransactionServiceService,
              private expenseService:ExpenseService) { }

  ngOnInit() {
     this.validateForm = this.fb.group({
     });
    this.getTransactions();
    this.getCategories();
  }

  getCategories():void{
    var url="api/category";
    this.expenseService.getCategories(url)
      .subscribe(categories=>this.categories=categories);
  }

  getTransactions():void{
    this.accountTransactionService.getTransactions()
      .subscribe(transactions=>this.transactions=transactions);
  }

  addExpense(expense:Expense): void{
    if(!expense){return; }
    this.expenseService.addExpense(expense)
      .subscribe(
        res=>console.log(res)
      );
  }

  buildDateString(accountTransaction:AccountTransaction):string{
    console.log("datetostring:"+new Date(accountTransaction.year,accountTransaction.month-1,accountTransaction.day).toLocaleDateString());
    return  new Date(accountTransaction.year,accountTransaction.month-1,accountTransaction.day).toLocaleDateString();
  }

  buildDate(accountTransaction:AccountTransaction):Date{
    console.log(accountTransaction.month)
    return  new Date(accountTransaction.year,accountTransaction.month-1,accountTransaction.day);
  }
  
  select(accountTransaction:AccountTransaction):void{
    this.isVisible=true;
    this.selectedTransaction=accountTransaction;
    console.log("open:" + this.selectedTransaction);
  }

  handleCancel(): void {
    this.isVisible = false;
  }

  onChangeCategory(result: Category): void {
    console.log('onChange: ', result);
    console.log('selected: '+this.selectedCategory.name)
  }

  submitForm(): void {
    this.isVisible = false;
    
    console.log(" allocate: "+this.selectedCategory.name+": " +this.selectedCategory.id);
    this.addExpense(this.convertToExpense(this.selectedTransaction));
    this.isDisable=true;
    this.isVisible = false;
  }

  convertToExpense(accountTransaction:AccountTransaction):Expense{
    var expense:Expense={
      "id":null,
      "amount":accountTransaction.amount,
      "description":accountTransaction.description,
      "day":accountTransaction.day,
      "month":accountTransaction.month,
      "year":accountTransaction.year,
      "category":this.selectedCategory
    }
    return expense;
  }
}
