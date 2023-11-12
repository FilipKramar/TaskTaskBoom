import { Component } from '@angular/core';
import { ApirequestService } from '../services/apirequestservice.service';

@Component({
  selector: 'app-members',
  templateUrl: './members.component.html',
  styleUrls: ['./members.component.scss']
})
export class MembersComponent {
  members$ = this.apiRequestService.getAllMembers();

  constructor(private apiRequestService:ApirequestService){}




}
