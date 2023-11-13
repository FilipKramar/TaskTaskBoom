import { Component } from '@angular/core';
import { ApirequestService } from '../services/apirequestservice.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
})
export class DashboardComponent {
  tasks: any;
  userstories: any;
  alltasks: any;
  constructor(private apiRequestService: ApirequestService) {}

  ngOnInit(): void {
    this.apiRequestService.getMyTasks().subscribe(
      (data) => {
        this.tasks = data;
      },
      (error) => {
        console.error('Error fetching data:', error);
      }
    );

    this.apiRequestService.getAllUserstory().subscribe(
      (data) => {
        this.userstories = data;
      },
      (error) => {
        console.error('Error fetching data:', error);
      }
    );

    this.apiRequestService.getAllTasks().subscribe(
      (data) => {
        this.alltasks = data;
      },
      (error) => {
        console.error('Error fetching data:', error);
      }
    );
  }
}
