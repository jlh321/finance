import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import { Observable, of } from 'rxjs';


import { Expense } from './expense';
import { Category } from '../category/category';

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {

  private baseExpenseUrl='api/expense';
  httpOptions={
    headers:new HttpHeaders({'Content-Type':'application/json'})
  };

  constructor(
    private http:HttpClient,
  ) { }

  //different situation for display
  buildGetUrl (type:number,day:number,month:number,year:number) : string{
    var url:string;
    console.log("type:"+type+"  month:"+month);
    switch (type){
    case 1:
      url=this.baseExpenseUrl+'/getbyday'+'?day='+day+'&month='+month+'&year='+year;
      break;
    case 2:
      console.log("enter");
      url=this.baseExpenseUrl+'/getbymonth'+'?month='+month+'&year='+year;
     
      break;
    case 3:
      url=this.baseExpenseUrl+'/getbyyear'+'?year='+year;
      break;
    default:
      url=this.baseExpenseUrl;
    }
    return url;
  }

getExpenses(url:string):Observable<Expense[]>{
    return this.http.get<Expense[]>(url);
}

updateExpense(expense: Expense):Observable<any>{
  return this.http.put(this.baseExpenseUrl,expense,this.httpOptions);
}

addExpense(expense:Expense):Observable<Expense>{
  console.log("enter add");
  return this.http.post<Expense>(this.baseExpenseUrl,expense,this.httpOptions);
}

deleteExpense(expense: Expense):Observable<Expense>{
   var httpOptions={
    headers:new HttpHeaders({'Content-Type':'application/json'}),
    body:expense
  };
  return this.http.delete<Expense>(this.baseExpenseUrl,httpOptions);
}

getCategories(url:string):Observable<Category[]>{
  return this.http.get<Category[]>(url);
}
}
