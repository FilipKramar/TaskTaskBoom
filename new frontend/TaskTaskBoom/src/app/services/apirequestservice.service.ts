import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { apiUrl } from '../enviroments/enviroments';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ApirequestserviceService {

  constructor(private http: HttpClient,private router: Router) { }

  LoginUser(data:any){
    const url = `${apiUrl.key}users`;
    this.http.post<number>(url, data).subscribe(
      (userId: number) => {
        this.router.navigate(['/home']);
        console.log(userId);
      },
      (error) => {
        alert('Wrong username or password');
      }
    );
  }
  RegisterUser(data:any){
    const url = `${apiUrl.key}users/register`;
    console.log(data);
    this.http.post<void>(url, data).subscribe(
      () => {
        alert('User created sucessfully');
        this.router.navigate(['/login']);
      },
      (error) => {
        alert('Cant register');
      }
    );
    
  }

  }



