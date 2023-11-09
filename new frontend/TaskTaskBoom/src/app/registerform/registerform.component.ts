import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-registerform',
  templateUrl: './registerform.component.html',
  styleUrls: ['./registerform.component.scss'],
})
export class RegisterformComponent {
  loginFormGroup: FormGroup = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
  });
  @Output() dataSubmitted = new EventEmitter<{
    username: string;
    password: string;
    firstName: string;
    lastName: string;
  }>();

  collectFormData() {
    const username = this.loginFormGroup.get('username')?.value;
    const password = this.loginFormGroup.get('password')?.value;
    const firstName = this.loginFormGroup.get('firstName')?.value;
    const lastName = this.loginFormGroup.get('lastName')?.value;
    this.dataSubmitted.emit({ username, password, firstName, lastName });
  }
}
