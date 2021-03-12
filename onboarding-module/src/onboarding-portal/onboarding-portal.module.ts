import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { ChartsModule } from 'ng2-charts';

import { OnboardeeService } from './services/onboardee.service';

import { OnboardingPortalRoutingModule } from './onboarding-portal-routing.module';
import { OnboardingPortalComponent } from './onboarding-portal.component';
import { NewOnboardeeComponent } from './components/new-onboardee/new-onboardee.component';
import { ViewOnboardeeComponent } from './components/view-onboardee/view-onboardee.component';
import { EditOnboardeeComponent } from './components/edit-onboardee/edit-onboardee.component';
import { GraphicalViewComponent } from './components/graphical-view/graphical-view.component';


@NgModule({
  declarations: [
    OnboardingPortalComponent,
    NewOnboardeeComponent,
    ViewOnboardeeComponent,
    EditOnboardeeComponent,
    GraphicalViewComponent
  ],
  imports: [
    CommonModule,
    OnboardingPortalRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    ChartsModule,
  ],
  providers: [OnboardeeService],
  bootstrap: [OnboardingPortalComponent]
})
export class OnboardingPortalModule { }
