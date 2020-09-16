import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import { Observable, of } from 'rxjs';

import {AccountTransaction} from './AccountTransaction';
import {Account} from './Account';

@Injectable({
  providedIn: 'root'
})
export class AccountTransactionServiceService {

  
  private baseAccountTransactionUrl='api/AccountTransaction';
  httpOptions={
    headers:new HttpHeaders({'Content-Type':'application/json'})
  };

  constructor(private http:HttpClient) { }

  getTransactions():Observable<AccountTransaction[]>{
    return this.http.get<AccountTransaction[]>(this.baseAccountTransactionUrl);
}

}
