import { Application } from './../../model/Application';
import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';

import { ErrorDialogComponent } from './../../../shared/components/error-dialog/error-dialog.component';
import { Problem } from './../../../shared/model/problem';
import { ApplicationService } from './../../services/ApplicationService';

@Component({
  selector: 'app-application-form',
  templateUrl: './application-form.component.html',
  styleUrls: ['./application-form.component.scss']
})
export class ApplicationFormComponent implements OnInit {

  form = this.formBuilder.group({
    id: [''],
    name: ['', [ Validators.required,
          Validators.minLength(4),
          Validators.maxLength(10)]],
    address: ['', [Validators.required]],
  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private service: ApplicationService,
    private snackBar: MatSnackBar,
    private dialog: MatDialog,
    private location: Location,
    private route: ActivatedRoute
  ) {
    const app: Application = this.route.snapshot.data['app'];
    this.form.setValue(app);
  }

  ngOnInit(): void {}

  onSubmit() {
    this.service.save(this.form.value).subscribe(
      () => {
        this.onSucess();
        this.onCancel();
      },
      (e) => this.onError(e.error)
    );
  }

  onCancel() {
    this.location.back();
  }

  private onSucess() {
    this.snackBar.open('Salvo com sucesso!', '', { duration: 5000 });
  }

  private onError(err: Problem) {
    this.dialog.open(ErrorDialogComponent, {
      data: err,
    });
  }

}
