import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable, of } from 'rxjs';

import { Application } from './../model/Application';
import { ApplicationService } from './../services/ApplicationService';

@Injectable({
  providedIn: 'root',
})
export class ApplicationResolverGuard implements Resolve<Application> {

  constructor(private service: ApplicationService) {}

  resolve(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<Application> {
    if (route.params && route.params['id']) {
      return this.service.loadById(route.params['id']);
    }
    return of({
      id: '',
      name: '',
      address: '',
    });
  }
}
