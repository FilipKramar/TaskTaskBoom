import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyopentasksComponent } from './myopentasks.component';

describe('MyopentasksComponent', () => {
  let component: MyopentasksComponent;
  let fixture: ComponentFixture<MyopentasksComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MyopentasksComponent]
    });
    fixture = TestBed.createComponent(MyopentasksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
