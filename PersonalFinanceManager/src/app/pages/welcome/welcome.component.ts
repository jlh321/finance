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
  constructor(
    private dataService:DataService,
    private datePipe: DatePipe
  ) { }

  ngOnInit() {
    this.date = Date.now();
    this.getData(this.date);
  }

  onChange(result: Date): void {
    console.log('onChange: ', result);
    console.log('onChange: ', this.date);
    this.getData(result);
  }

  getData(date: Date) {
    let year = this.datePipe.transform(date,"y");
    let month = this.datePipe.transform(date,"M");
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

    this.getChartTwoData();
  }

  getChartTwoData() {
    
    this.initChartTwo();
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
          data: ['rose1', 'rose2', 'rose3', 'rose4', 'rose5', 'rose6', 'rose7', 'rose8']
      },
      series: [
          {
              name: '半径模式',
              type: 'pie',
              radius: [20, 110],
              roseType: 'radius',
              emphasis: {
                  label: {
                      show: true
                  }
              },
              data: [
                  {value: 10, name: 'rose1'},
                  {value: 5, name: 'rose2'},
                  {value: 15, name: 'rose3'},
                  {value: 25, name: 'rose4'},
                  {value: 20, name: 'rose5'},
                  {value: 35, name: 'rose6'},
                  {value: 30, name: 'rose7'},
                  {value: 40, name: 'rose8'}
              ]
          }
      ]
    };
  }

}
