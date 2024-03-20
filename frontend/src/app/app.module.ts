import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { NavbarComponent } from './navbar/navbar.component';
import { MainpartComponent } from './mainpart/mainpart.component';
import { NewTaskComponent } from './new-task/new-task.component';
import { MyprojectComponent } from './myproject/myproject.component';
import { AllprojectsComponent } from './allprojects/allprojects.component';
import { TaskboardComponent } from './taskboard/taskboard.component';
import { NewprojektComponent } from './newprojekt/newprojekt.component';
import { ProjectarchiveComponent } from './projectarchive/projectarchive.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { FormsModule } from '@angular/forms';
import { ProfileComponent } from './profile/profile.component';
import { HttpClientModule } from '@angular/common/http';
import { EdittaskComponent } from './edittask/edittask.component';
import { ListofusersComponent } from './listofusers/listofusers.component';
import { MatSnackBarModule } from '@angular/material/snack-bar'; 

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavbarComponent,
    MainpartComponent,
    NewTaskComponent,
    MyprojectComponent,
    AllprojectsComponent,
    TaskboardComponent,
    NewprojektComponent,
    ProjectarchiveComponent,
    LoginFormComponent,
    ProfileComponent,
    EdittaskComponent,
    ListofusersComponent,
    
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule, MatSnackBarModule,BrowserAnimationsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
