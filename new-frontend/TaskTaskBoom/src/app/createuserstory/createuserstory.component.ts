import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ApirequestService } from '../services/apirequestservice.service';

@Component({
  selector: 'app-createuserstory',
  templateUrl: './createuserstory.component.html',
  styleUrls: ['./createuserstory.component.scss']
})
export class CreateuserstoryComponent {
  constructor(private apiRequestService:ApirequestService){}
  createUserstoryFormGroup: FormGroup = new FormGroup({
    description: new FormControl('', Validators.required),
    name: new FormControl('', Validators.required),
    currentStage: new FormControl('', Validators.required),
    tasks: new FormControl([])
  });


  collectFormData() {
    this.apiRequestService.createAUserstory(this.createUserstoryFormGroup.value);
  }

}
