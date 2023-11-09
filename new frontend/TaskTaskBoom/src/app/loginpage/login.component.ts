import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { apiUrl } from '../enviroments/enviroments';
import { LoginformComponent } from '../loginform/loginform.component';
import { RegisterformComponent } from '../registerform/registerform.component';
import { ApirequestserviceService } from '../services/apirequestservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  constructor(
    private http: HttpClient,
    private router: Router,
    private apiRequestService: ApirequestserviceService
  ) {}
  onLogin(componentReference: any) {
    if (componentReference instanceof LoginformComponent) {
      componentReference.dataSubmitted.subscribe((data: any) => {
        this.apiRequestService.LoginUser(data);
      });
    } else if (componentReference instanceof RegisterformComponent) {
      componentReference.dataSubmitted.subscribe((data: any) => {
        this.apiRequestService.RegisterUser(data);
      });
    }
  }
}
