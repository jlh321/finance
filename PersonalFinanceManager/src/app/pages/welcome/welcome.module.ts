import { NgModule } from '@angular/core';

import { WelcomeRoutingModule } from './welcome-routing.module';

import { WelcomeComponent } from './welcome.component';
import { CommonModule } from '@angular/common';
import { NzDatePickerModule } from 'ng-zorro-antd/date-picker';
import { FormsModule} from '@angular/forms';
import { DatePipe } from '@angular/common';
import { NgxEchartsModule } from 'ngx-echarts';
import { NzGridModule } from 'ng-zorro-antd/grid';


@NgModule({
  imports: [
    WelcomeRoutingModule,
    CommonModule,
    NzDatePickerModule,
    FormsModule,
    NgxEchartsModule,
    NzGridModule
  ],
  providers: [DatePipe],
  declarations: [WelcomeComponent],
  exports: [WelcomeComponent]
})
export class WelcomeModule { }
