import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-addExpense',
  templateUrl: './addExpense.component.html',
  styleUrls: ['./addExpense.component.css']
})
export class AddExpenseComponent implements OnInit {
  validateForm!: FormGroup;


  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.validateForm = this.fb.group({
      datePicker: [null],
      datePickerTime: [null],
      monthPicker: [null],
      rangePicker: [[]],
      rangePickerTime: [[]],
      timePicker: [null]
    });
  }

  submitForm(): void {
    console.log(this.validateForm.value);
  }

}
