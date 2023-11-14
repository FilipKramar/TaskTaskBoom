import { Component } from '@angular/core';
import { ApirequestService } from '../services/apirequestservice.service';
import { CreatetaskComponent } from '../createtask/createtask.component';
import { EdittaskComponent } from '../edittask/edittask.component';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.scss']
})
export class TasksComponent {
  constructor(
    private apiRequestService: ApirequestService
  ) {}
  onLogin(componentReference: any) {
    if (componentReference instanceof CreatetaskComponent) {
      componentReference.dataSubmitted.subscribe((data: any) => {
        this.apiRequestService.createATask(data);
      });
    } else if (componentReference instanceof EdittaskComponent) {
      componentReference.dataSubmitted.subscribe((data: any) => {
        this.apiRequestService.registerUser(data);
      });
    }
  }

}
