import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EditOnboardeeComponent } from './components/edit-onboardee/edit-onboardee.component';
import { GraphicalViewComponent } from './components/graphical-view/graphical-view.component';
import { NewOnboardeeComponent } from './components/new-onboardee/new-onboardee.component';
import { ViewOnboardeeComponent } from './components/view-onboardee/view-onboardee.component';

import { OnboardingPortalComponent } from './onboarding-portal.component';

const routes: Routes = [
  { path: '', component: OnboardingPortalComponent },
  { path: 'new-onboardee', component: NewOnboardeeComponent },
  { path: 'view-onboardee/:id', component: ViewOnboardeeComponent},
  { path: 'edit-onboardee', component: EditOnboardeeComponent },
  { path: 'graphical-view', component: GraphicalViewComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OnboardingPortalRoutingModule { }
	