import { ApplicationsModule } from './applications/applications.module';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: '', pathMatch: 'full',  redirectTo: 'applications'},
  {
    path: 'applications', loadChildren: ()=> import('./applications/applications.module').then(m => m.ApplicationsModule)
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
