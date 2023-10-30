import { Injectable, inject } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { map, shareReplay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class NavbarService {
  private breakpointObserver = inject(BreakpointObserver);
  isHandset$: Observable<boolean> = this.breakpointObserver
    .observe(Breakpoints.Handset)
    .pipe(
      map((result) => result.matches),
      shareReplay()
    );

  private isNavOpen$ = new BehaviorSubject<boolean>(false);

  toggleNavState(isOpen: boolean) {
    this.isNavOpen$.next(isOpen);
  }

  getNavState() {
    return this.isNavOpen$.asObservable();
  }
}
