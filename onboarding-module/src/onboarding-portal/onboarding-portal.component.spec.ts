import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OnboardingPortalComponent } from './onboarding-portal.component';

describe('OnboardingPortalComponent', () => {
  let component: OnboardingPortalComponent;
  let fixture: ComponentFixture<OnboardingPortalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OnboardingPortalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OnboardingPortalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
