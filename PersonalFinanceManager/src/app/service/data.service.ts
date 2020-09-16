import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private headers:HttpHeaders;
  constructor(private http: HttpClient ) {
      this.headers = new HttpHeaders();
      this.headers.set('Content-Type','application/json');
    }
  
  getAll(url:string): Observable<any> {
    return this.http.get(url,{headers:this.headers});
  }

  getAllByMonth(url:string,year:any,month:any): Observable<any> {
    let requestUrl = url+"?month="+month+"&year="+year;
    return this.http.get(requestUrl,{headers:this.headers});
  }

  delete(url:string,id:any): Observable<any> {
    let requestUrl = url+"/"+id;
    return this.http.delete(requestUrl,{headers:this.headers});
  }

  edit(url:string,data:any): Observable<any> {
    return this.http.post(url, data,{headers:this.headers});
  }

  create(url:string,data:any): Observable<any> {
    return this.http.post(url, data,{headers:this.headers});
  }
}
