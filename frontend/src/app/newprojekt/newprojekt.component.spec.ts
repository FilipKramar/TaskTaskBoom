import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewprojektComponent } from './newprojekt.component';

describe('NewprojektComponent', () => {
  let component: NewprojektComponent;
  let fixture: ComponentFixture<NewprojektComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NewprojektComponent]
    });
    fixture = TestBed.createComponent(NewprojektComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
