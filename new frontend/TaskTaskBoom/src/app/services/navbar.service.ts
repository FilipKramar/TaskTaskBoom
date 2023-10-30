import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';

@Injectable()
export class NavbarService {
  private toggleSidenavSource = new Subject<void>();
  private isSideNavOpen$ = new Subject<boolean>();

  toggleSidenav$ = this.toggleSidenavSource.asObservable();
  isSideNavOpenObs$: Observable<boolean> = this.isSideNavOpen$.asObservable();

  toggleSidenav() {
    this.toggleSidenavSource.next();
  }

  setIsSideNavOpen(isOpen: boolean) {
    this.isSideNavOpen$.next(isOpen);
  }
}
