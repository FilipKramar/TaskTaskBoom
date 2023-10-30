import { Component, inject } from '@angular/core';
import { Observable } from 'rxjs';

import { NavbarService } from '../services/navbar.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent {
  isHandset$: Observable<boolean>;
  isNavOpen?: boolean;

  constructor(private navbarService: NavbarService) {
    this.isHandset$ = this.navbarService.isHandset$;
    this.navbarService.getNavState().subscribe((isOpen) => {
      this.isNavOpen = isOpen;
    });
  }
}
