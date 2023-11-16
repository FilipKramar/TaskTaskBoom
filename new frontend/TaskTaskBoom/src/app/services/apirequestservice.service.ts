import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { apiUrl } from '../enviroments/enviroments';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApirequestService {
  constructor(private http: HttpClient, private router: Router) {}

  loginUser(data: any) {
    const url = `${apiUrl.key}users`;
    this.http.post<number>(url, data).subscribe(
      (Id: number) => {
        this.router.navigate(['/home']);
        sessionStorage.setItem('userid', Id.toString());
      },
      (error) => {
        alert('Wrong username or password');
      }
    );
  }
  registerUser(data: any) {
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
    const url = `${apiUrl.key}usertasks/${sessionStorage.getItem('userid')}`;
    return this.http.get<any>(url);
  }

  getAllTasks(): Observable<any> {
    const url = `${apiUrl.key}usertasks`;
    return this.http.get<any>(url);
  }

  getAllUserstory(): Observable<any> {
    const url = `${apiUrl.key}userstories`;
    return this.http.get<any>(url);
  }

  createATask(data: any) {
    const url = `${apiUrl.key}tasks`;
    this.http.post<void>(url, data).subscribe(
      () => {
        alert('Task created sucessfuly');
        this.router.navigate(['/home/dashboard']);
      },
      (error) => {
        alert('Error creating task');
      }
    );
  }

  createAUserstory(data: any) {
    const url = `${apiUrl.key}userstories`;
    this.http.post<void>(url, data).subscribe(
      () => {
        alert('Userstory created sucessfuly');
        this.router.navigate(['/home/dashboard']);
      },
      (error) => {
        alert('Error creating userstory');
      }
    );
  }
  getTaskData(taskId: number): Observable<any> {
    const url = `${apiUrl.key}tasks/${taskId}`;
    return this.http.get<any>(url);
  }

  getUserstoryData(usestoryId: number): Observable<any> {
    const url = `${apiUrl.key}userstories/${usestoryId}`;
    return this.http.get<any>(url);
  }
  editATask(data: any) {
    const url = `${apiUrl.key}tasks`;
    this.http.put(url, data).subscribe(
      () => {
        alert('Task edited sucessfuly');
        this.router.navigate(['/home/dashboard']);
      },
      (error) => {
        alert('Error editing task');
      }
    );
  }

  editAnUserstory(data: any) {
    const url = `${apiUrl.key}userstories`;

    this.http.put(url, data).subscribe(
      () => {
        alert('Userstory edited sucessfuly');
        this.router.navigate(['/home/dashboard']);
      },
      (error) => {
        alert('Error editing userstory');
      }
    );
  }
}
