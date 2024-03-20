import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {JSONPlaceholderService} from '../services/jsonplaceholder.service';
import { ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-mainpart',
  templateUrl: './mainpart.component.html',
  styleUrls: ['./mainpart.component.scss']
})
export class MainpartComponent implements OnInit {

  data: any[] = [];
  data1: any[] = [];
  dataUserStory: any[]=[];
  userId:number=1;
  constructor(private router: Router, private jsonPlaceholder: JSONPlaceholderService,private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.queryParams.subscribe((queryParams) => {
      this.userId = queryParams['id'];
      // Now, you have the userId available for use in your component.
      console.log('User ID:', this.userId);
    });

    // GET zahjtev sa dobijenim ID-om.
    this.jsonPlaceholder.getMyTasks(this.userId).subscribe(
      (data) => {
        console.log(data);
        this.data = data;
      },
      (error) => {
        console.error('Error fetching data:', error);
      }
    );

    this.jsonPlaceholder.getAllTasks().subscribe((response) => {
      this.data1 = response;
    });

    this.jsonPlaceholder.getAllUserstory().subscribe((data) =>{
      this.dataUserStory=data;
    })

  }

  goNewTask() {
    this.router.navigate(['/new-task']);
  }
}
