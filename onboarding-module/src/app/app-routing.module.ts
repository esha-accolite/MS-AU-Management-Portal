import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SignInComponent } from '../app/components/sign-in/sign-in.component';
import { SignUpComponent } from '../app/components/sign-up/sign-up.component';
import { DashboardComponent } from '../app/components/dashboard/dashboard.component';
import { ForgotPasswordComponent } from '../app/components/forgot-password/forgot-password.component';
import { VerifyEmailComponent } from '../app/components/verify-email/verify-email.component';
import { OnboardeeListComponent } from '../app/components/onboardee-list/onboardee-list.component';
import { AddNewOnboardeeComponent } from './components/add-new-onboardee/add-new-onboardee.component';

import { AuthGuard } from "../app/shared/guard/auth.guard";

const routes: Routes = [
  {
    path: 'onboarding-portal',
    loadChildren: () => import('../onboarding-portal/onboarding-portal.module').then(m => m.OnboardingPortalModule)
  },
  { path: '', redirectTo: '/sign-in', pathMatch: 'full' },
  { path: 'sign-in', component: SignInComponent },
  { path: 'register-user', component: SignUpComponent },
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
  { path: 'forgot-password', component: ForgotPasswordComponent },
  { path: 'verify-email-address', component: VerifyEmailComponent },
  { path: 'onboardee-list', component: OnboardeeListComponent },
  { path: 'add-new-onboardee', component: AddNewOnboardeeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
