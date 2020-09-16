import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategoryComponent } from './category.component';
import { CategoryRoutingModule } from './category-routing.module';
import { NzListModule } from 'ng-zorro-antd/list';
import { NzModalModule } from 'ng-zorro-antd/modal';
import { NzInputModule } from 'ng-zorro-antd/input';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    CategoryRoutingModule,
    NzListModule,
    NzModalModule,
    NzInputModule,
    FormsModule
  ],
  declarations: [
    CategoryComponent,
  ],
  exports: [CategoryComponent]
})
export class CategoryModule { }
