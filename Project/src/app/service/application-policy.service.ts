import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApplicationPolicy } from '../model/application-policy';
@Injectable({
  providedIn: 'root'
})
export class ApplicationPolicyService {
  private registerUrl: string;

  constructor(private http: HttpClient) {
    this.registerUrl = 'api/application/';

  }
  getPolicy() {
    return this.http.get<ApplicationPolicy[]>("api/application/status/Application Submitted");
  }
  ggetPolicy() {
    return this.http.get<ApplicationPolicy[]>("api/application/");
  }

  public postPolicy(applicationpolicy: ApplicationPolicy) {
    // console.log(applicationpolicy)
    return this.http.post<ApplicationPolicy>(this.registerUrl, applicationpolicy);
  }
}