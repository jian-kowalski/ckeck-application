import { Application } from './../model/Application';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { CrudService } from './../../shared/crud/crud.service';


@Injectable({
  providedIn: 'root',
})
export class ApplicationService extends CrudService<Application> {

  constructor(protected override httpClient: HttpClient) {
    super(httpClient, "apps");
  }


}
