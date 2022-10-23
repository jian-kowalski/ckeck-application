import { Application } from './../../model/Application';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-applications-list',
  templateUrl: './applications-list.component.html',
  styleUrls: ['./applications-list.component.scss'],
})
export class ApplicationsListComponent implements OnInit {
  readonly displayedColumns = ['name', 'address', 'actions'];

  @Input() applications: Application[] = [];
  @Output() add = new EventEmitter(false);
  @Output() edit = new EventEmitter(false);
  @Output() delete = new EventEmitter(false);
  constructor() {}

  ngOnInit(): void {}

  onAdd() {
    this.add.emit(true);
  }

  onEdit(app: Application) {
    this.edit.emit(app);
  }

  onDelete(app: Application) {
    this.delete.emit(app);
  }
}
