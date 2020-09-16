import { Component, OnInit } from '@angular/core';
import { DataService } from '../../service/data.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  date:any;
  monthFormat = 'yyyy/MM';
  totalExpense:number;
  totalBudget:number;
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
    this.dataService.getAllByMonth("/api/budget/sum",year,month).subscribe(res=>{
      this.totalBudget = res;
      console.log(this.totalBudget)
    });
    this.dataService.getAllByMonth("/api/expense/all",year,month).subscribe(res=>{
      this.totalExpense = res;
      console.log(this.totalExpense)
    });
  }

  option = {
    tooltip: {
        formatter: '{a} <br/>{b} : {c}%'
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    series: [
        {
            name: '',
            type: 'gauge',
            detail: {formatter: '{value}%'},
            data: [{value: 50, name: 'Expense to Budget'}]
        }
    ]
};

}
