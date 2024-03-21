import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OpenuserstoriesComponent } from './openuserstories.component';

describe('OpenuserstoriesComponent', () => {
  let component: OpenuserstoriesComponent;
  let fixture: ComponentFixture<OpenuserstoriesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OpenuserstoriesComponent]
    });
    fixture = TestBed.createComponent(OpenuserstoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
