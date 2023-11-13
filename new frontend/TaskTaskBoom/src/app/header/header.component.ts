import { Component } from '@angular/core';
import { ApirequestService } from '../services/apirequestservice.service';
import { Observable } from 'rxjs';

import { NavbarService } from '../services/navbar.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {
  isHandset$: Observable<boolean>;
  isNavOpen: boolean = false;
 /*  members$ = this.apiRequestService.userId(); */

  constructor(
    private navbarService: NavbarService,
    private apiRequestService: ApirequestService
  ) {
    this.isHandset$ = this.navbarService.isHandset$;
  }
  toggleNav() {
    this.isNavOpen = !this.isNavOpen;
    this.navbarService.toggleNavState(this.isNavOpen);
  }
  getUsername() {

    console.log(this.apiRequestService.userId);
  }
}
