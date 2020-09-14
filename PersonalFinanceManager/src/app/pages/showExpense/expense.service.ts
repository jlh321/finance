import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import { Observable, of } from 'rxjs';


import { Expense } from './expense';

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {

  private baseExpenseUrl='expense';
  httpOptions={
    headers:new HttpHeaders({'Content-Type':'application/json'})
  };

  constructor(
    private http:HttpClient,
  ) { }

  //different situation for display
  buildGetUrl (type:number,day:number,month:number,year:number) : string{
    var url;
    switch (type){
    case 1:
      url=this.baseExpenseUrl+'?day='+day+'&month='+month+'&year='+year;
    case 2:
      url=this.baseExpenseUrl+'?month='+month+'&year='+year;
    case 3:
      url=this.baseExpenseUrl+'?year='+year;
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
  return this.http.post<Expense>(this.baseExpenseUrl,expense,this.httpOptions);
}

deleteExpense(catogory:Expense | number):Observable<Expense>{
  const id=typeof catogory==='number'?catogory:catogory.id;
  const url='${this.catogoryUrl}/${id}';
  
  return this.http.delete<Expense>(url,this.httpOptions);
}


}
