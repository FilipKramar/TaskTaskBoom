import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainpartComponent } from './mainpart/mainpart.component';
import { NewTaskComponent } from '../app/new-task/new-task.component';
import { MyprojectComponent } from './myproject/myproject.component';
import { AllprojectsComponent } from './allprojects/allprojects.component';
import { TaskboardComponent } from './taskboard/taskboard.component';
import { ProjectarchiveComponent } from './projectarchive/projectarchive.component';
import { NewprojektComponent } from './newprojekt/newprojekt.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { ProfileComponent } from './profile/profile.component';
import { EdittaskComponent } from './edittask/edittask.component';
import { ListofusersComponent } from './listofusers/listofusers.component';


const routes: Routes = [
  {path: '', component:LoginFormComponent},
  {path: 'home', component:MainpartComponent},
  {path: 'new-task', component: NewTaskComponent },
  {path: 'myproject', component:MyprojectComponent},
  {path: 'allprojects', component: AllprojectsComponent },
  {path: 'taskboard', component:TaskboardComponent},
  {path: 'projectarchive', component:ProjectarchiveComponent},
  {path: 'newproject', component:NewprojektComponent},
  {path: 'profile', component:ProfileComponent},
  {path: 'edit/:taskId', component:EdittaskComponent},
  {path: 'listofusers', component:ListofusersComponent},
  

  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
