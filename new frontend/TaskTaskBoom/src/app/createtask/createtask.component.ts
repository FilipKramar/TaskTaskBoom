import { Component, EventEmitter, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ApirequestService } from '../services/apirequestservice.service';

@Component({
  selector: 'app-createtask',
  templateUrl: './createtask.component.html',
  styleUrls: ['./createtask.component.scss'],
})
export class CreatetaskComponent {
  constructor(private apiRequestService:ApirequestService){}
  createTaskFormGroup: FormGroup = new FormGroup({
    description: new FormControl('', Validators.required),
    user_id: new FormControl('', Validators.required),
    priority: new FormControl('', Validators.required),
  });
  
  collectFormData() {
    this.apiRequestService.createATask(this.createTaskFormGroup.value);
  
  }
}
