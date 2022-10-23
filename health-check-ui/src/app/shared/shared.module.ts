import { AppMaterialModule } from './app-material/app-material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [

  ],
  imports: [
    CommonModule,
    AppMaterialModule
  ],
  exports: [
    AppMaterialModule
  ]
})
export class SharedModule { }
