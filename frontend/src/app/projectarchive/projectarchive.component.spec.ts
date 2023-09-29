import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectarchiveComponent } from './projectarchive.component';

describe('ProjectarchiveComponent', () => {
  let component: ProjectarchiveComponent;
  let fixture: ComponentFixture<ProjectarchiveComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProjectarchiveComponent]
    });
    fixture = TestBed.createComponent(ProjectarchiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
