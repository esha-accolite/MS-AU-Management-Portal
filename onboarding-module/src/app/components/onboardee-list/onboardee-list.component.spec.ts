import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OnboardeeListComponent } from './onboardee-list.component';

describe('OnboardeeListComponent', () => {
  let component: OnboardeeListComponent;
  let fixture: ComponentFixture<OnboardeeListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OnboardeeListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OnboardeeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
