import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewOnboardeeComponent } from './add-new-onboardee.component';

describe('AddNewOnboardeeComponent', () => {
  let component: AddNewOnboardeeComponent;
  let fixture: ComponentFixture<AddNewOnboardeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddNewOnboardeeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNewOnboardeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
