import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { apiUrl } from '../enviroments/enviroments';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApirequestService {
  userId: number = 0;

  constructor(private http: HttpClient, private router: Router) {}

  LoginUser(data: any) {
    const url = `${apiUrl.key}users`;
    this.http.post<number>(url, data).subscribe(
      (Id: number) => {
        this.router.navigate(['/home']);
        this.userId = Id;
      },
      (error) => {
        alert('Wrong username or password');
      }
    );
  }
  RegisterUser(data: any) {
    const url = `${apiUrl.key}users/register`;
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

  getAllMembers(): Observable<any> {
    const url = `${apiUrl.key}users`;
    return this.http.get<any>(url);
  }

  getMyTasks(): Observable<any> {
    const url = `${apiUrl.key}usertasks/${this.userId}`;
    return this.http.get<any>(url);
  }

  getAllTasks(): Observable<any> {
    const url = `${apiUrl.key}usertasks`;
    return this.http.get<any>(url);
  }

  getTask(taskId: number): Observable<any> {
    const url = `${apiUrl.key}tasks`;
    return this.http.get<any>(url);
  }

  getAllUserstory(): Observable<any> {
    const url = `${apiUrl.key}userstories`;
    return this.http.get<any>(url);
  }
}
