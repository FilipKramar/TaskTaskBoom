import { Component, Output,EventEmitter } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-createuserstory',
  templateUrl: './createuserstory.component.html',
  styleUrls: ['./createuserstory.component.scss']
})
export class CreateuserstoryComponent {
  createUserstoryFormGroup: FormGroup = new FormGroup({
    description: new FormControl('', Validators.required),
    name: new FormControl('', Validators.required),
    currentStage: new FormControl('', Validators.required),
  });
  @Output() dataSubmitted = new EventEmitter<{
    description: string;
    name: string;
    currentStage: string;
  }>();

  collectFormData() {
    const description = this.createUserstoryFormGroup.get('description')?.value;
    const currentStage = this.createUserstoryFormGroup.get('currentStage')?.value;
    const name = this.createUserstoryFormGroup.get('name')?.value;
    this.dataSubmitted.emit({ description, name, currentStage });
  }

}
