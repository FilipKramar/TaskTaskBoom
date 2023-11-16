import { Component } from '@angular/core';
import { ApirequestService } from '../services/apirequestservice.service';
import { CreateuserstoryComponent } from '../createuserstory/createuserstory.component';
import { EdituserstoryComponent } from '../edituserstory/edituserstory.component';

@Component({
  selector: 'app-userstories',
  templateUrl: './userstories.component.html',
  styleUrls: ['./userstories.component.scss']
})
export class UserstoriesComponent {
  constructor(private apiRequestService: ApirequestService) {}
  onClick(componentReference: any) {

    console.log(componentReference);
    if (componentReference instanceof CreateuserstoryComponent) {
      componentReference.dataSubmitted.subscribe((data: any) => {
        console.log("jel ovo radi");
        this.apiRequestService.createAUserstory(data);
      });
    } else if (componentReference instanceof EdituserstoryComponent) {
        componentReference.dataSubmitted.subscribe((data: any) => {
        this.apiRequestService.editAnUserstory(data);
      });
    }
  }

}
