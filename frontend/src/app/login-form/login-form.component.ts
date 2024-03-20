import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root',
})
@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss'],
})
export class LoginFormComponent {
  title = 'login';
  data: Array<any>;

  // formSubmitted = false;
  loginFailed = false;

  formData = {
    username: '',
    password: '',
  };

  constructor(
    private http: HttpClient, private router: Router
  ) {
    this.data = new Array<any>();
  }
  // ngOnInit(): void {
  //   // You can perform any initialization logic here.
  // }

  onLogin() {
    const loginData = {
      username: this.formData.username,
      password: this.formData.password,
    };
  

    console.log(loginData);
    this.http.post<number>('{', loginData).subscribe(
      (userId: number) => {
        console.log('Logged in');
        this.router.navigate(['/home'], { queryParams: { id: userId } });
      },
      (error) => {
        console.log('Log in failed');
        alert('Wrong username or password');
        this.formData.username = '';
        this.formData.password = '';
      }
    );
  }
  

}
