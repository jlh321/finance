import { Component, OnInit } from '@angular/core';
import { DataService } from '../../service/data.service';
import { DatePipe } from '@angular/common';
import { id_ID } from 'ng-zorro-antd/i18n';
import { EChartOption } from 'echarts';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  option1: EChartOption = {};
  option2: EChartOption = {};

  date:any;
  monthFormat = 'yyyy/MM';
  totalExpense:number;
  totalBudget:number;
  expenseToBudget:any;
  expenseList:any;
  categoryList:any;
  catExpenseList:any;
  catExpenseMap:any;

  constructor(
    private dataService:DataService,
    private datePipe: DatePipe
  ) { }

  ngOnInit() {
    this.date = Date.now();
    this.getData();
  }

  onChange(result: Date): void {
    console.log('onChange: ', result);
    console.log('onChange: ', this.date);
    this.getData();
  }

  getData() {
    this.getChartOneData()
    this.getChartTwoData();
  }

  getChartOneData() {
    let year = this.datePipe.transform(this.date,"y");
    let month = this.datePipe.transform(this.date,"M");
    this.dataService.getAllByMonth("/api/expense/all",year,month).subscribe(res=>{
      this.totalExpense = res;
      console.log(this.totalExpense);
      if(this.totalBudget == 0){
        this.expenseToBudget = 0;
      }else{
        this.expenseToBudget = ((this.totalExpense/this.totalBudget)*100).toFixed(1);
      }
      console.log(this.expenseToBudget);
      this.initChartOne(this.expenseToBudget);
    });
    this.dataService.getAllByMonth("/api/budget/sum",year,month).subscribe(res=>{
      this.totalBudget = res;
      console.log(this.totalBudget);
      if(this.totalBudget == 0){
        this.expenseToBudget =0;
      }else{
        this.expenseToBudget = ((this.totalExpense/this.totalBudget)*100).toFixed(1);
      }
      console.log(this.expenseToBudget);
      this.initChartOne(this.expenseToBudget);
    });
  }

  getChartTwoData() {
    let year = this.datePipe.transform(this.date,"y");
    let month = this.datePipe.transform(this.date,"M");
    this.dataService.getAllByMonth("/api/expense/getbymonth",year,month).subscribe(res=>{
      this.expenseList = res;
      console.log(this.expenseList);
      this.categoryList = new Array<string>();
      this.catExpenseList = new Array<CatExpense>();
      this.catExpenseMap = new Map();
      for(let i=0;i<this.expenseList.length;i++){
        let catgoryName = this.expenseList[i].category.name;
        let amount = this.expenseList[i].amount;
        this.categoryList.push(catgoryName);
        if(this.catExpenseMap.has(catgoryName)){
          amount = amount + this.catExpenseMap.get(catgoryName);
          this.catExpenseMap.set(catgoryName,amount);
        }else{
          this.catExpenseMap.set(catgoryName,amount);
        }
      }
      console.log(this.categoryList);
      console.log(this.catExpenseMap);
      for (let entry of this.catExpenseMap.entries()) {
        let catExpense = new CatExpense();
        catExpense.name = entry[0];
        catExpense.value = entry[1];
        this.catExpenseList.push(catExpense);
      }
      console.log(this.catExpenseList);
      this.initChartTwo();
    });
  }

  initChartOne(data){
    this.option1 = {
      title: {
        text: 'Proportion of Expenses',
        left: 'center'
      },
      tooltip: {
          formatter: '{a} <br/>{b} : {c}%'
      },
      series: [
          {
              name: '',
              type: 'gauge',
              detail: {formatter: '{value}%'},
              data: [{value: data, name: 'Expense to Budget'}]
          }
      ]
    };
  }

  initChartTwo(){
    this.option2 = {
      title: {
          text: 'Proportion of Categories Expense',
          left: 'center'
      },
      tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
      },
      legend: {
          left: 'center',
          top: 'bottom',
          data: this.categoryList
      },
      series: [
          {
              name: 'Category Expense',
              type: 'pie',
              radius: [20, 110],
              roseType: 'radius',
              emphasis: {
                  label: {
                      show: true
                  }
              },
              data:this.catExpenseList
          }
      ]
    };
  }

}

class CatExpense{
  value:any;
  name:any;
}