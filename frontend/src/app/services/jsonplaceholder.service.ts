import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class JSONPlaceholderService {
  constructor(private http: HttpClient) {}

  getData(): Observable<any> {
    const url = 'http://localhost:8080/api/v1/users';
    return this.http.get<any>(url);
  }

  getMyTasks(userId: number): Observable<any> {
    const url = `http://localhost:8080/api/v1/usertasks/${userId}`;
    return this.http.get<any>(url);
  }

  getAllTasks():Observable<any>{
    const url=`http://localhost:8080/api/v1/usertasks`;
    return this.http.get<any>(url);
  }

  getTask(taskId:number): Observable<any>{
    const url=`http://localhost:8080/api/v1/tasks`;
    return this.http.get<any>(url);
  }

  getAllUserstory(): Observable<any>{
    const url=`http://localhost:8080/api/v1/userstories`
    return this.http.get<any>(url);
  }

  getAllUsers(): Observable<any>{
    const url=`http://localhost:8080/api/v1/users`
    return this.http.get<any>(url);
  }



  
 // 10.15.18.116
}
