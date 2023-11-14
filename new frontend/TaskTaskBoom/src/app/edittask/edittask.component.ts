import { Component, EventEmitter, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-edittask',
  templateUrl: './edittask.component.html',
  styleUrls: ['./edittask.component.scss']
})
export class EdittaskComponent {
  createTaskFormGroup: FormGroup = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });
  @Output() dataSubmitted = new EventEmitter<{
    username: string;
    password: string;
  }>();

  collectFormData() {
    const username = this.createTaskFormGroup.get('username')?.value;
    const password = this.createTaskFormGroup.get('password')?.value;
    this.dataSubmitted.emit({ username, password });
  }

}
