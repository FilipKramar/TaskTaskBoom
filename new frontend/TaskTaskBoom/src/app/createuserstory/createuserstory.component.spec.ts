import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateuserstoryComponent } from './createuserstory.component';

describe('CreateuserstoryComponent', () => {
  let component: CreateuserstoryComponent;
  let fixture: ComponentFixture<CreateuserstoryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateuserstoryComponent]
    });
    fixture = TestBed.createComponent(CreateuserstoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
