import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-budget',
  templateUrl: './budget.component.html',
  styleUrls: ['./budget.component.css']
})
export class BudgetComponent implements OnInit {

  date = null;
  monthFormat = 'yyyy/MM';
  constructor() { }

  ngOnInit() {
    this.date = new Date();
  }

  onChange(result: Date): void {
    console.log('onChange: ', result);
    console.log('onChange: ', this.date);
  }

  
}
