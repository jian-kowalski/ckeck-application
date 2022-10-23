import { ApplicationResolverGuard } from './guards/application-resolver.guard';
import { ApplicationFormComponent } from './containers/application-form/application-form.component';
import { ApplicationsComponent } from './containers/applications/applications.component';


import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


const routes: Routes = [
  { path: '', component: ApplicationsComponent },
  {
    path: 'new',
    component: ApplicationFormComponent,
    resolve: {
      app: ApplicationResolverGuard,
    },
  },
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
