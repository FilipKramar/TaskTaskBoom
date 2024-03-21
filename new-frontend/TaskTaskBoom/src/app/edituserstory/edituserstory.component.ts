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
  editUserstoryFormGroup: FormGroup = new FormGroup({
    description: new FormControl('', Validators.required),
    name: new FormControl('', Validators.required),
    complexity: new FormControl('', Validators.required),
    currentStage: new FormControl('', Validators.required),
    tasks: new FormControl([]),
    userstoryEditAssigneeDTO: new FormGroup({
      user_id: new FormControl('', Validators.required),
      userstory_id: new FormControl('', Validators.required),
    }),
  });

  collectFormData() {
    this.apiRequestService.editAnUserstory(this.editUserstoryFormGroup.value);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.apiRequestService.getUserstoryData(params['userstoryid']).subscribe((data) => {
        const taskIds = data.tasks.map((task: { id: number }) => task.id);

  
        this.editUserstoryFormGroup.setValue({
          description: data.description,
          name: data.name,
          complexity: data.complexity,
          currentStage: data.currentStage,
          tasks: taskIds,
          userstoryEditAssigneeDTO: {
            user_id: data.userId,
            userstory_id: data.userstoryId,
          },
        });
      });
    });
  }
  
  }



