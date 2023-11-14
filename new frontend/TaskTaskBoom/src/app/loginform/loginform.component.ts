import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-loginform',
  templateUrl: './loginform.component.html',
  styleUrls: ['./loginform.component.scss'],
})
export class LoginformComponent {
  loginFormGroup: FormGroup = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });
  @Output() dataSubmitted = new EventEmitter<{
    username: string;
    password: string;
  }>();

  collectFormData() {
    const username = this.loginFormGroup.get('username')?.value;
    const password = this.loginFormGroup.get('password')?.value;
    this.dataSubmitted.emit({ username, password });
  }

}
