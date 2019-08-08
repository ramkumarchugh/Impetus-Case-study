import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { registerLocaleData } from '@angular/common';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { PoliciesComponent } from './policies/policies.component';
import { AboutusComponent } from './aboutus/aboutus.component';
// import { AdminComponent } from './admin/admin.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
// import { WorkflowComponent } from './workflow/workflow.component';
import { DependentAddComponent } from './dependent-add/dependent-add.component';
import { ApplicationAddComponent } from './application-add/application-add.component';
import { BaseTemplateComponent } from './base-template/base-template.component';
import { UserTemplateComponent } from './user-template/user-template.component';
import { UnderwriterComponent } from './underwriter/underwriter.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGaurdService } from './service/auth-gaurd.service';
import { ApplicationViewComponent } from './application-view/application-view.component';
import { AdminTemplateComponent } from './admin-template/admin-template.component';
import { UserInfoComponent } from './user-info/user-info.component';
import { PolicyTableComponent } from './policy-table/policy-table.component';
import { ApplicationUnderwriterComponent } from './application-underwriter/application-underwriter.component';
import { GenericPlanDetailsComponent } from './generic-plan-details/generic-plan-details.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { WorkflowActivityComponent } from './workflow-activity/workflow-activity.component';
import { AdminAuthGuardService } from './service/admin-auth-guard.service';
import { UnderwriterAuthGuardService} from './service/underwriter-auth-guard.service';
import { AdminapplicationviewComponent } from './adminapplicationview/adminapplicationview.component';




const routes: Routes = [

  { path: '', redirectTo: 'insurance', pathMatch: 'full' },

  {
    path: 'insurance', component: BaseTemplateComponent, children: [
      { path: '', redirectTo: 'home', pathMatch: 'full' },
      { path: 'home', component: HomeComponent },
      { path: 'policies', component: PoliciesComponent },
      { path: 'aboutus', component: AboutusComponent },
      { path: 'login', component: LoginComponent },
      { path: 'register', component: RegisterComponent },
      { path: 'forgotpassword', component: ForgotpasswordComponent },
      { path: 'plans/:id', component: GenericPlanDetailsComponent },
      { path: 'application-add', component: ApplicationAddComponent },


    ]

  },
  // {path : '**', component : PageNotFoundComponent},
  {
    path: 'insurance/user', component: UserTemplateComponent, canActivate: [AuthGaurdService], children: [
      { path: '', redirectTo: 'policies', pathMatch: 'full' },
      { path: 'policies', component: PoliciesComponent },
      { path: 'workflow', component: WorkflowActivityComponent },
      { path: 'application-add/:id', component: ApplicationAddComponent },
      { path: 'plans/:id', component: GenericPlanDetailsComponent },
      { path: 'dependentadd', component: DependentAddComponent }, //currently NIU
      { path: 'admin-template', component: AdminTemplateComponent },
      { path: 'signOut', component: LogoutComponent, canActivate: [AuthGaurdService] },
      { path: 'application-view', component: ApplicationViewComponent },

    ]
  },
  {
    path: 'insurance/admin', component: AdminTemplateComponent, canActivate: [AdminAuthGuardService], children: [
      { path: '', redirectTo: 'userinfo', pathMatch: 'full' },
      { path: 'userinfo', component: UserInfoComponent },
      { path: 'policy/:id', component: PolicyTableComponent },
      { path: 'signOut', component: LogoutComponent, canActivate: [AuthGaurdService] },
      { path: 'adminapplicationview', component: AdminapplicationviewComponent },
    ]
  },
  {
    path: 'insurance/underwriter', component: UnderwriterComponent, canActivate: [UnderwriterAuthGuardService], children: [
      { path: '', redirectTo: 'application-underwriter', pathMatch: 'full' },
      { path: 'underwriter', component: UnderwriterComponent },
      { path: 'application-underwriter', component: ApplicationUnderwriterComponent },
      { path: 'signOut', component: LogoutComponent, canActivate: [AuthGaurdService] },
    ]
  }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
