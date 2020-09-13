import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  public anyList:any
  public categoryItem:any = "";
  isVisible = false;
  constructor(private http:HttpClient) { }

  ngOnInit() {
    this.http.get("/budget/sum").subscribe(res=>{ this.anyList = res })
  }
  
  showModal(item:any): void {
    this.categoryItem = item;
    this.isVisible = true;
    console.log(item.name);
    console.log(this.categoryItem.name);
  }

  handleOk(): void {
    console.log('Button ok clicked!');
    this.isVisible = false;
  }

  handleCancel(): void {
    console.log('Button cancel clicked!');
    this.isVisible = false;
  }

  categories = [
    {
      id: 1,
      name: "Utilities"
    },
    {
      id: 2,
      name: "Travel"
    },
    {
      id: 3,
      name: "Groceries"
    },
    {
      id: 4,
      name: "Drinks"
    },
    {
      id: 5,
      name: "Cell Phone"
    },
    {
      id: 6,
      name: "Car Payments"
    },
    {
      id: 7,
      name: "Fun Money"
    }
  ];

  
}