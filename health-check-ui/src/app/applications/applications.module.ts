import { AppMaterialModule } from './../shared/app-material/app-material.module';
import { ApplicationsComponent } from './containers/applications/applications.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '../shared/shared.module';
import { ApplicationsRoutingModule } from './applications-routing.module';
import { ApplicationsListComponent } from './components/applications-list/applications-list.component';



@NgModule({
  declarations: [
    ApplicationsComponent,
    ApplicationsListComponent
  ],
  imports: [
    CommonModule,
    ApplicationsRoutingModule,
    SharedModule,
    AppMaterialModule
  ]
})
export class ApplicationsModule { }
