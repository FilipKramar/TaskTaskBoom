import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edittask',
  templateUrl: './edittask.component.html',
  styleUrls: ['./edittask.component.scss']
})
export class EdittaskComponent {

  descriptionEditPut: string;
  priorityEditPut: string ;
  statusEditPut:string;
  usersEditPut: any;
  complexityEditPut:number;
  taskId:any;
  taskData: any;

  constructor(private http:HttpClient,private route: ActivatedRoute){
    this.descriptionEditPut='',
    this.priorityEditPut='',
    this.statusEditPut='',
    this.usersEditPut='',
    this.complexityEditPut=0,
    this.taskId=''
    
  }
  
  
  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.taskId = +params['taskId'];
      this.fetchTaskData();
    });
  }
  fetchTaskData() {
    const url = `http://localhost:8080/api/v1/tasks/${this.taskId}`;
    this.http.get(url).subscribe((data: any) => {
     
      this.descriptionEditPut = data.description;
      this.priorityEditPut = data.priority;
      this.statusEditPut = data.status;
      this.usersEditPut = this.setSelectedUser(data.user_id);
      this.complexityEditPut = data.complexity.toString();
      this.taskId = data.task_id.toString();

      console.log(this.taskId,this.complexityEditPut)
    });
  }


  
setSelectedUser(user_id: number):string {
  switch (user_id) {
    case 1:
    return '1';
    case 5:
      return '5';
    case 6:
      return '6';
    case 8:
      return '8';
    case 7:
      return '7';
    case 4:
      return '4';
    case 9:
      return '9';
    default:
      return 'null';
  }
}



  putEditData(){
      let url = `http://localhost:8080/api/v1/tasks`;
      const putTaskData = {
        description: this.descriptionEditPut,
        priority: this.priorityEditPut?.toUpperCase(),
        status: this.statusEditPut?.toUpperCase(),
        complexity:this.complexityEditPut,
        taskEditAssigneeDTO: {
          userid: Number(this.usersEditPut),
          taskid: Number(this.taskId)
        }
      };
      
    
      this.http.put(url, putTaskData).toPromise().then((data: any) => {
        console.log(data);
        console.log(JSON.stringify(data.json));
      });
    }

}
