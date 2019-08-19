import { Component, OnInit , AfterViewInit, ViewChild} from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MatTableModule } from '@angular/material/table';
import { RestService } from '../service/rest.service';
import { ApplicationPolicy } from '../model/application-policy';
import { AuthenticationService } from '../service/authentication.service';
import { Application } from '../application-add/application-add.component';
import { ApplicationPolicyService } from '../service/application-policy.service';
import { MatPaginator, MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material';
import {Inject} from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Workflow } from '../model/workflow.model';
import { User } from '../model/user';



@Component({
  selector: 'app-application-underwriter',
  templateUrl: './application-underwriter.component.html',
  styleUrls: ['./application-underwriter.component.css']
})
export class ApplicationUnderwriterComponent implements OnInit{
 
  Uname: string;
  displayedColumns = ['applicationId','user.name','sumAssured', 'noOfYears', 'age','salary', 'premium','workflow'];
  userid: number;
   
//  applications:any = [];
  applications:any;
  
//  dataSource = new MatTableDataSource();
  dataSource : MatTableDataSource<any>;

  policies:string[];
  workflows:Workflow[];
  horizontalPosition:MatSnackBarHorizontalPosition = 'center';
  verticalPosition : MatSnackBarVerticalPosition = 'top';
  
  @ViewChild(MatSort, { static: true }) sort: MatSort;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  workf: Application[];

  constructor(private policyService:ApplicationPolicyService, private restService: RestService, private authService: AuthenticationService,private snackBar: MatSnackBar) { }
/* 
  ngOnInit() {
    this.policyService.getPolicy().subscribe(response=>this.handleSuccessfulResponse(response))
    this.dataSource.sort = this.sort;
    this.userid = this.authService.getUserId();
    console.log(this.userid);
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
 */

ngOnInit() {
  this.policyService.getPolicy().subscribe(response=>this.handleSuccessfulResponse(response))
  //this.dataSource.sort = this.sort;
  this.userid = this.authService.getUserId();
  console.log(this.userid);
  var i=0;
  this.restService.get<any>('api/application/status/Under Review', null).subscribe(data => {
      this.applications=data;
      this.Uname=User.name;
      console.log(this.Uname);
      
      this.dataSource = new MatTableDataSource(this.applications);
      console.log("Table Data", JSON.stringify(this.dataSource.data));
      console.log("Table Data", JSON.stringify(this.dataSource.data[0].user.name));
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
  });
}


applyFilter(filterValue: string) {
  this.dataSource.filter = filterValue.trim().toLowerCase();
}



handleSuccessfulResponse(response){
  this.policies=response;
}
 /*  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
    this.userid = this.authService.getUserId();
    console.log(this.userid);
    var i=0;
    this.restService.get<Application[]>('api/application/status/Application Submitted', null).subscribe(data => {
      this.applications = data;
      this.dataSource = new MatTableDataSource(this.applications);
    });
  } */

  showWorkflow(data){

    // console.log("in workflow",data);
   
  //  console.log(data.applicationId);  
  this.workflows = [];
  this.restService.get<Workflow[]>('api/application/workflow/applicationId/' + data.applicationId, null).subscribe(data => {
    // console.log("current workflows: "+JSON.stringify(data));
    this.workflows = data;
  });
}

  borderType(workflow:Workflow){
    if(workflow.status === 'approved')
    { return "alert-success";
  }
  else if(workflow.status=== 'rejected'){
    return "alert-danger";
  }
  else
{
  return "alert-warning";
}
    
  }

  approve(data){
    // console.log("in approve",data);
    data.status="approved";
    
    this.restService.put<Application[]>('api/application/' + data.applicationId,data ,null).subscribe(data => {

      // console.log("Application approved: "+ JSON.stringify(data))
      //alert("application approved");
      this.ngOnInit();
    } );
    //api hit .subs( 
/*
    this.ngOnInit();
    ) 
    */
  }

  reject(data){
    // console.log("in reject",data);
    data.status="rejected";
    this.restService.put<Application[]>('api/application/' + data.applicationId,data ,null).subscribe(data => {

      // console.log("Application approved: "+ JSON.stringify(data))
      //this.openSnackBar('APPLICATION REJECTED ','');
     // alert("application rejected");
      this.ngOnInit();
    } );
    
  }

  openSnackBar( message,status){
    this.snackBar.open(message, status, {
      duration: 2000,
      horizontalPosition : this.horizontalPosition,
      verticalPosition : this.verticalPosition,
      panelClass: ['blue-snackbar']
    });
    
  }

}
 

