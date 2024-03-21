import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EdituserstoryComponent } from './edituserstory.component';

describe('EdituserstoryComponent', () => {
  let component: EdituserstoryComponent;
  let fixture: ComponentFixture<EdituserstoryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EdituserstoryComponent]
    });
    fixture = TestBed.createComponent(EdituserstoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
