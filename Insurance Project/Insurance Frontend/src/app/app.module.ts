import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { BodyComponent } from './body/body.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { PoliciesComponent } from './policies/policies.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { Ng5SliderModule } from 'ng5-slider';

import { ReactiveFormsModule, FormsModule} from '@angular/forms';
import{FormGroup,FormControl,Validators}from '@angular/forms';
// import { AdminComponent } from './admin/admin.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
// import { WorkflowComponent } from './workflow/workflow.component';
import { DependentAddComponent } from './dependent-add/dependent-add.component';
import { ApplicationAddComponent } from './application-add/application-add.component';
import { ShowHidePasswordModule } from 'ngx-show-hide-password';
import {MatFormFieldModule, MatIconModule, MatButtonModule, MatInputModule} from '@angular/material';
import { BaseTemplateComponent } from './base-template/base-template.component';
import { UserTemplateComponent } from './user-template/user-template.component';
import { UnderwriterComponent } from './underwriter/underwriter.component';
import { LogoutComponent } from './logout/logout.component';
import { ApplicationViewComponent } from './application-view/application-view.component';
import {MatTableModule} from '@angular/material/table';
import { AdminTemplateComponent } from './admin-template/admin-template.component';
import { ApplicationUnderwriterComponent } from './application-underwriter/application-underwriter.component';
import { GenericPlanDetailsComponent } from './generic-plan-details/generic-plan-details.component';
import { PolicyTableComponent } from './policy-table/policy-table.component';
import { UserInfoComponent } from './user-info/user-info.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { WorkflowActivityComponent } from './workflow-activity/workflow-activity.component';

import {MatPaginatorModule} from '@angular/material/paginator';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatSortModule} from '@angular/material/sort';
import {MatCardModule} from '@angular/material/card';
import { AdminapplicationviewComponent } from './adminapplicationview/adminapplicationview.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';













@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    BodyComponent,
    RegisterComponent,
    HomeComponent,
    PoliciesComponent,
    AboutusComponent,
    // AdminComponent,
    ForgotpasswordComponent,
    // WorkflowComponent,
    DependentAddComponent,
    ApplicationAddComponent,
    BaseTemplateComponent,
    UserTemplateComponent,
    UnderwriterComponent,
    LogoutComponent,
    ApplicationViewComponent,
    AdminTemplateComponent,
    ApplicationUnderwriterComponent,
    GenericPlanDetailsComponent,
    PolicyTableComponent,
    UserInfoComponent,
  
    AppComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    BodyComponent,
    RegisterComponent,
    HomeComponent,
    PoliciesComponent,
    AboutusComponent,
    ForgotpasswordComponent,
    // WorkflowComponent,
    DependentAddComponent,
    ApplicationAddComponent,
    BaseTemplateComponent,
    UserTemplateComponent,
    UnderwriterComponent,
    LogoutComponent,
    AdminTemplateComponent,
    UserInfoComponent,
    PolicyTableComponent,
    ApplicationUnderwriterComponent,
    GenericPlanDetailsComponent,
    PageNotFoundComponent,
    WorkflowActivityComponent,
    AdminapplicationviewComponent,
    
   
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    Ng5SliderModule ,
    ShowHidePasswordModule,
    MatFormFieldModule,
    MatIconModule,
    ReactiveFormsModule,
    MatTableModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    Ng5SliderModule ,
    ShowHidePasswordModule,
    MatFormFieldModule,
    MatIconModule,
    ReactiveFormsModule,
MatPaginatorModule,
BrowserAnimationsModule,
MatSortModule,
MatCardModule,
MatButtonModule,
MatInputModule,
MatSnackBarModule
    
   

   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

