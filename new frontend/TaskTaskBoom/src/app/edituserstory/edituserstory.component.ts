import { Component, EventEmitter, Output, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ApirequestService } from '../services/apirequestservice.service';


@Component({
  selector: 'app-edituserstory',
  templateUrl: './edituserstory.component.html',
  styleUrls: ['./edituserstory.component.scss']
})
export class EdituserstoryComponent implements OnInit {
  form: any;
  constructor(
    private route: ActivatedRoute,
    private apiRequestService: ApirequestService
  ) {}
  createUserstoryFormGroup: FormGroup = new FormGroup({
    description: new FormControl('', Validators.required),
    name: new FormControl('', Validators.required),
    complexity: new FormControl('', Validators.required),
    currentStage: new FormControl('', Validators.required),
    userstoryEditAssigneeDTO: new FormGroup({
      userId: new FormControl('', Validators.required),
      userstoryId: new FormControl('', Validators.required),
    }),
  });
  
  @Output() dataSubmitted = new EventEmitter<{
    description: string;
    name: string;
    complexity: number;
    currentStage: string;
    userstoryEditAssigneeDTO: {
      user_id: number;
      userstory_id: number;
    };
  }>();
  
  collectFormData() {
    const {
      description,
      name,
      complexity,
      currentStage,
      userstoryEditAssigneeDTO: { userId, userstoryId },
    } = this.createUserstoryFormGroup.value;
  
    const userIdAsNumber = Number(userId);
    const userstoryIdAsNumber = Number(userstoryId);
  
    this.dataSubmitted.emit({
      description,
      name,
      complexity,
      currentStage,
      userstoryEditAssigneeDTO: {
        user_id: userIdAsNumber,
        userstory_id: userstoryIdAsNumber,
      },
    });
  }
  
  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.apiRequestService.getUserstoryData(params['userstoryid']).subscribe((data) => {
        this.createUserstoryFormGroup.setValue({
          description: data.description,
          name: data.name,
          complexity: data.complexity,
          currentStage: data.currentStage,
          userstoryEditAssigneeDTO: {
            userId: data.userId,
            userstoryId: data.userstoryId,
          },
        });
      });
    });
  }
}  


