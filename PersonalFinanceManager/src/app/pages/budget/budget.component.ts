import { Component, OnInit } from '@angular/core';
import { DataService } from '../../service/data.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-budget',
  templateUrl: './budget.component.html',
  styleUrls: ['./budget.component.css']
})
export class BudgetComponent implements OnInit {
  
  editValue:any;
  isEditVisible = false;
  budget:any;
  date = null;
  monthFormat = 'yyyy/MM';
  totalBudget:number;
  categoryList:any;
  budgetList:any;
  showList:any;
  catBudgetMap:Map<string,BudgetEntity>;
  constructor(
    private dataService:DataService,
    private datePipe: DatePipe
  ) { }

  ngOnInit() {
    this.date = new Date();
    this.getData(this.date);
  }

  onChange(result: Date): void {
    console.log('onChange: ', result);
    console.log('onChange: ', this.date);
    this.getData(result);
  }

  getData(date:Date):void {
    this.categoryList = new Array();
    this.budgetList = new Array();
    this.catBudgetMap = new Map<string,BudgetEntity>();
    let year = this.datePipe.transform(date,"y");
    let month = this.datePipe.transform(date,"M");
    this.dataService.getAllByMonth("/api/budget/sum",year,month).subscribe(res=>{
      this.totalBudget = res;
      this.initTable();
    });
    this.dataService.getAllByMonth("/api/budget",year,month).subscribe(res=>{
      this.budgetList = res;
      console.log(this.budgetList);
      this.initTable();
    });
    this.dataService.getAll("/api/category").subscribe(res=>{
      this.categoryList = res;
      console.log(this.categoryList);
      this.initTable();
    });
  }

  initTable() {
    for(let i=0;i<this.categoryList.length;i++){
      let budgetEntity = new BudgetEntity();
      budgetEntity.amount = "Not Set";
      budgetEntity.category = this.categoryList[i];
      budgetEntity.month = this.datePipe.transform(this.date,"M");
      budgetEntity.year = this.datePipe.transform(this.date,"y");
      this.catBudgetMap.set(this.categoryList[i].name,budgetEntity);
    }
    for(let j=0;j<this.budgetList.length;j++){
      if(this.catBudgetMap.size!=0){
        let budgetEntity = this.catBudgetMap.get(this.budgetList[j].category.name);
        budgetEntity.id = this.budgetList[j].id;
        budgetEntity.amount = this.budgetList[j].amount;
        this.catBudgetMap.set(this.budgetList[j].category.name,budgetEntity);
      }
    }
    this.showList = new Array();
    for (let value of this.catBudgetMap.values()) {
      this.showList.push(value);                
    }
    console.log("showlist"); 
    console.log(this.showList); 
  }

  showEditModal(item:any): void {
    this.budget = item;
    this.isEditVisible = true;
    if(item.amount=="Not Set"){
      this.editValue = "";
    }else {
      this.editValue = item.amount;
    }
    console.log(this.budget);
  }

  handleEditOk(): void {
    this.budget.amount = this.editValue;
    this.dataService.edit("/api/budget",this.budget).subscribe(res=>{
      console.log(res);
      this.getData(this.date);
    });
    this.isEditVisible = false;
  }

  handleEditCancel(): void {
    this.isEditVisible = false;
  }

}

class BudgetEntity{
  id:any;
  amount:any;
  category:Category;
  year:any;
  month:any;
}

class Category{
  id:any;
  name:any;
}