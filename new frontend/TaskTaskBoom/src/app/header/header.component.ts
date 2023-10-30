import { Component, inject } from '@angular/core';

import { Observable } from 'rxjs';

import { NavbarService } from '../services/navbar.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
  isHandset$: Observable<boolean>;
  isNavOpen: boolean = false;

  constructor(private navbarService: NavbarService) {
    this.isHandset$ = this.navbarService.isHandset$;
  }
  toggleNav() {
    this.isNavOpen = !this.isNavOpen; 
    this.navbarService.toggleNavState(this.isNavOpen);
  }
}
