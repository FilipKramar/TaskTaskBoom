import { Component } from '@angular/core';
import {JSONPlaceholderService} from '../services/jsonplaceholder.service';
 
@Component({
  selector: 'app-listofusers',
  templateUrl: './listofusers.component.html',
  styleUrls: ['./listofusers.component.scss']
})
export class ListofusersComponent {
  dataUser: any[] = [];

  constructor(private jsonPlaceholder:JSONPlaceholderService){}

  ngOnInit(){
    this.jsonPlaceholder.getAllUsers().subscribe(
      (data) =>{
        this.dataUser=data;
      }
    )
  }

}
