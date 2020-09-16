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
  // categories:Category[]=[{
  //   "id":"5f61d18349a55832271dd89b",
  //   "name":"Car Payments"
  // }];;
  public expenses:Expense[]
  public categories:Category[];


  constructor(private expenseService:ExpenseService,
              private modal:NzModalService,
              private fb: FormBuilder) { }

  ngOnInit() {
    this.validateForm = this.fb.group({
      datePicker: [null],
    });
    this.getExpenses(2,0,9,2020);
    this.getCategories();
  }


  getExpenses(type:number,day:number,month:number,year:number): void {
    console.log("type:"+type+"  month:"+month);
    var url=this.expenseService.buildGetUrl(type,day,month,year);
    console.log(url);
    this.expenseService.getExpenses(url)
      .subscribe(expenses=>this.expenses=expenses);
  }

  getCategories():void{
    var url="api/category";
    this.expenseService.getCategories(url)
      .subscribe(categories=>this.categories=categories);
  }

  addExpense(expense:Expense): void{
    this.expenseService.addExpense(expense)
      .subscribe(expense=>
      this.expenses.push(expense));
  }

  updateExpense(expense:Expense): void {
   // this.expenses=this.expenses.filter(e=>e.id!=expense.id);
   // this.expenses.push(expense);
    var tmpexpense=this.expenses.find(e=>e.id==expense.id);
    tmpexpense=expense;
    this.expenseService.updateExpense(expense)
      .subscribe();
  }

  deleteExpense(expense:Expense){
    this.expenses=this.expenses.filter(e=>e!=expense);
    this.expenseService.deleteExpense(expense).subscribe(
      // res=>this.expenses.filter(e=>e!=expense),
      // error=>console.log(error)
    );
  }

  buildDateString(expense:Expense):string{
    console.log("datetostring:"+new Date(expense.year,expense.month-1,expense.day).toLocaleDateString());
    return  new Date(expense.year,expense.month-1,expense.day).toLocaleDateString();
  }

  buildDate(expense:Expense):Date{
    console.log(expense.month)
    return  new Date(expense.year,expense.month-1,expense.day);
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



