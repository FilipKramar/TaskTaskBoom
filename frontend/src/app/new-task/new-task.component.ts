import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';



@Component({
  selector: 'app-new-task',
  templateUrl: './new-task.component.html',
  styleUrls: ['./new-task.component.scss']
})
export class NewTaskComponent {

  descriptionPost: string;
  priorityPost: string;
  usersPost: any;

  constructor(private http:HttpClient, private snackbar:MatSnackBar){
    this.descriptionPost='',
    this.priorityPost='',
    this.usersPost=0
  }


  postData(){
      let url = "http://localhost:8080/api/v1/tasks";
      const postTaskData = {
        description: this.descriptionPost, 
        priority: this.priorityPost?.toUpperCase(),
        user_id:Number(this.usersPost),
      }
      console.log(postTaskData)
      this.http.post(url, postTaskData).toPromise().then((data: any) => {
        console.log(data);
        console.log(JSON.stringify(data)); 
        this.showSuccessAlert();
      });
    }

    showSuccessAlert() {
      this.snackbar.open('Data is successfully sent!', 'Close', {
        duration: 3000,
        panelClass: ['alert', 'show', 'success'],
      });
    }
  }