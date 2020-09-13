import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategoryComponent } from './category.component';
import { CategoryRoutingModule } from './category-routing.module';
import { NzListModule } from 'ng-zorro-antd/list';
import { NzModalModule } from 'ng-zorro-antd/modal';

@NgModule({
  imports: [
    CommonModule,
    CategoryRoutingModule,
    NzListModule,
    NzModalModule
  ],
  declarations: [
    CategoryComponent,
  ],
  exports: [CategoryComponent]
})
export class CategoryModule { }
