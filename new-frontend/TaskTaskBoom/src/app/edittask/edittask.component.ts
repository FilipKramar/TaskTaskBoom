import { Component, EventEmitter, Output, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ApirequestService } from '../services/apirequestservice.service';

@Component({
  selector: 'app-edittask',
  templateUrl: './edittask.component.html',
  styleUrls: ['./edittask.component.scss'],
})
export class EdittaskComponent implements OnInit {
  form: any;
  constructor(
    private route: ActivatedRoute,
    private apiRequestService: ApirequestService
  ) {}
  createTaskFormGroup: FormGroup = new FormGroup({
    description: new FormControl('', Validators.required),
    priority: new FormControl('', Validators.required),
    status: new FormControl('', Validators.required),
    complexity: new FormControl('', Validators.required),
    taskEditAssigneeDTO: new FormGroup({
      userid: new FormControl('', Validators.required),
      taskid: new FormControl('', Validators.required),
    }),
  });

  collectFormData() {
    this.apiRequestService.editATask(this.createTaskFormGroup.value);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.apiRequestService.getTaskData(params['taskId']).subscribe((data) => {
        this.createTaskFormGroup.setValue({
          description: data.description,
          priority: data.priority,
          status: data.status,
          complexity: data.complexity,
          taskEditAssigneeDTO: {
            userid: data.user_id,
            taskid: data.task_id,
          },
        });
      });
    });
  }
}
