import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { NavbarService } from '../services/navbar.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {
  isHandset$: Observable<boolean>;
  isNavOpen: boolean = false;
  username = sessionStorage.getItem('username');

  constructor(
    private navbarService: NavbarService,  private router: Router  ) {
    this.isHandset$ = this.navbarService.isHandset$;
  }
  toggleNav() {
    this.isNavOpen = !this.isNavOpen;
    this.navbarService.toggleNavState(this.isNavOpen);
  }
  logout() {
    sessionStorage.removeItem('userid');
    sessionStorage.removeItem('username');
    this.router.navigate(['']);

  }
}
