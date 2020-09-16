import { Component, OnInit } from '@angular/core';
import { DataService } from '../../service/data.service'

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  public categoryList:any;
  public categoryItem:any = "";
  editValue:any;
  addValue = "";
  isEditVisible = false;
  isRemoveVisible = false;
  isAddVisible = false;
  constructor(
    private dataService:DataService
  ) { }

  ngOnInit() {
    this.getData();
  }

  getData():void {
    this.dataService.getAll("/api/category").subscribe(res=>{
      this.categoryList = res;
    });
  }
  
  showEditModal(item:any): void {
    this.categoryItem = item;
    this.isEditVisible = true;
    this.editValue = item.name;
    console.log(item.name);
    console.log(this.categoryItem.name);
  }

  handleEditOk(): void {
    this.categoryItem.name = this.editValue;
    this.dataService.edit("/api/category",this.categoryItem).subscribe(res=>{
      console.log(res);
      this.getData();
    });
    this.isEditVisible = false;
  }

  handleEditCancel(): void {
    this.isEditVisible = false;
  }

  showRemoveModal(item:any): void {
    this.categoryItem = item;
    this.isRemoveVisible = true;
    console.log(item.name);
    console.log(this.categoryItem.name);
  }

  handleRemoveOk(): void {
    this.dataService.delete("/api/category",this.categoryItem.id).subscribe(res=>{
      console.log(res);
      this.getData();
    });
    this.isRemoveVisible = false;
  }

  handleRemoveCancel(): void {
    this.isRemoveVisible = false;
  }

  showAddModal(): void {
    this.isAddVisible = true;
  }

  handleAddOk(): void {
    const data = {
      name:this.addValue
    }
    this.dataService.create("/api/category",data).subscribe(res=>{
      console.log(res);
      this.getData();
    });
    this.addValue = "";
    this.isAddVisible = false;
  }

  handleAddCancel(): void {
    this.isAddVisible = false;
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