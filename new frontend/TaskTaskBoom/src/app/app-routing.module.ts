import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainpageComponent } from './mainpage/mainpage.component';
import { LoginComponent } from './loginpage/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MembersComponent } from './members/members.component';
import { LoginformComponent } from './loginform/loginform.component';
import { RegisterformComponent } from './registerform/registerform.component';
import { TasksComponent } from './tasks/tasks.component';
import { CreatetaskComponent } from './createtask/createtask.component';
import { EdittaskComponent } from './edittask/edittask.component';
import { CreateuserstoryComponent } from './createuserstory/createuserstory.component';
import { EdituserstoryComponent } from './edituserstory/edituserstory.component';
import { UserstoriesComponent } from './userstories/userstories.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent,
    children: [
      { path: '', redirectTo: 'login', pathMatch: 'full' },
      { path: 'login', component: LoginformComponent },
      { path: 'register', component: RegisterformComponent },
    ],
  },
  {
    path: 'home',
    component: MainpageComponent,
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
      { path: 'dashboard', component: DashboardComponent },
      { path: 'members', component: MembersComponent },
      {
        path: 'task',
        component: TasksComponent,
        children: [
          { path: 'create', component: CreatetaskComponent },
          { path: 'edit/:taskId', component: EdittaskComponent },
        ],
      },
      {
        path: 'userstory',
        component: UserstoriesComponent,
        children: [
          { path: 'create', component: CreateuserstoryComponent },
          { path: 'edit/:userstoryid', component: EdituserstoryComponent },
        ],
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
