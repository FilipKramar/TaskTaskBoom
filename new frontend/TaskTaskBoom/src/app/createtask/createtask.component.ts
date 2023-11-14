import { Component, EventEmitter, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-createtask',
  templateUrl: './createtask.component.html',
  styleUrls: ['./createtask.component.scss'],
})
export class CreatetaskComponent {
  createTaskFormGroup: FormGroup = new FormGroup({
    description: new FormControl('', Validators.required),
    userid: new FormControl('', Validators.required),
    priority: new FormControl('', Validators.required),
  });
  @Output() dataSubmitted = new EventEmitter<{
    description: string;
    priority: string;
    user_id: number;
  }>();

  collectFormData() {
    const description = this.createTaskFormGroup.get('description')?.value;
    const priority = this.createTaskFormGroup.get('priority')?.value;
    const user_id = this.createTaskFormGroup.get('userid')?.value;

    this.dataSubmitted.emit({ description, priority, user_id });
  }
}
