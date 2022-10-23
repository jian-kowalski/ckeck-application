import { ApplicationsComponent } from './containers/applications/applications.component';


import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


const routes: Routes = [
  { path: '', component: ApplicationsComponent },
  // {
  //   path: 'new',
  //   component: ClientFormComponent,
  //   resolve: {
  //     client: ClientResolverGuard,
  //   },
  // },
  // {
  //   path: 'edit/:id',
  //   component: ClientFormComponent,
  //   resolve: {
  //     client: ClientResolverGuard,
  //   },
  // },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ApplicationsRoutingModule {}
