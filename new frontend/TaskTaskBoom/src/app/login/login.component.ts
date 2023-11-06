import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { apiUrl } from '../enviroments/enviroments';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  loginFormGroup: FormGroup;

  constructor(private http: HttpClient, private router: Router) {
    this.loginFormGroup = new FormGroup({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
    });
  }

  onLogin(formData: { username: string; password: string }) {
    const url = `${apiUrl.key}users`;

    this.http.post<number>(url, formData).subscribe(
      (userId: number) => {
        this.router.navigate(['/home']);
        console.log(userId);
      },
      (error) => {
        alert('Wrong username or password');
        this.loginFormGroup.reset();
      }
    );
  }
}
