import { Router, RouterModule, ActivatedRoute } from '@angular/router';
import { ApplicationService } from './../../services/ApplicationService';

import { Application } from './../../model/Application';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-applications',
  templateUrl: './applications.component.html',
  styleUrls: ['./applications.component.scss']
})
export class ApplicationsComponent implements OnInit {

  applications$: Observable<Application[]>;

  constructor(private service: ApplicationService, private router: Router, private route: ActivatedRoute) {
    this.applications$ = service.list();
  }


  ngOnInit(): void {
  }

   onAdd() {
    this.router.navigate(['new'], { relativeTo: this.route });
  }

}
