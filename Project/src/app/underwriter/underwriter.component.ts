import { Component, OnInit, ViewChild,AfterViewInit  } from '@angular/core';
import {ApplicationPolicyService} from '../service/application-policy.service';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MatTableModule } from '@angular/material/table';
import { RestService } from '../service/rest.service';
import { ApplicationPolicy } from '../model/application-policy';
import { AuthenticationService } from '../service/authentication.service';
import { Application } from '../application-add/application-add.component';

@Component({
  selector: 'app-underwriter',
  templateUrl: './underwriter.component.html',
  styleUrls: ['./underwriter.component.css']
})
export class UnderwriterComponent implements OnInit, AfterViewInit {
 
  displayedColumns: string[] = ['sumAssured', 'noOfYears', 'age','salary'];
  userid: number;
  applications:any = [];
  dataSource = new MatTableDataSource();

  policies:string[];
  @ViewChild(MatSort, { static: true }) sort: MatSort;
  getName: string;

  constructor(private policyService:ApplicationPolicyService, private restService: RestService, private authService: AuthenticationService) { }

  ngOnInit() {
    this.getName=localStorage.getItem('name');
    this.policyService.getPolicy().subscribe(response=>this.handleSuccessfulResponse(response))
    this.dataSource.sort = this.sort;
    this.userid = this.authService.getUserId();
    // console.log(this.userid);
    var i=0;
    this.restService.get<Application[]>('api/application/status/Application Submitted', null).subscribe(data => {
      data.forEach(res => {
                //var application = new Application("",1,1,1,null,1,"1l",1)
                var application = new Application(res.applicantname,res.sumAssured,res.noOfYears,res.age,res.dependents,res.premium,res.salary,res.noOfDependents);
                this.applications[i++]=application;
                this.dataSource = new MatTableDataSource(this.applications);
            })
    });
  }
handleSuccessfulResponse(response){
  this.policies=response;
}
  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
    this.userid = this.authService.getUserId();
    // console.log(this.userid);
    var i=0;
    this.restService.get<Application[]>('api/application/status/Application Submitted', null).subscribe(data => {
      this.applications = data;
      this.dataSource = new MatTableDataSource(this.applications);
    });
  }

}
 
