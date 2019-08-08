import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MatTableModule } from '@angular/material/table';
import { RestService } from '../service/rest.service';
import { ApplicationPolicy } from '../model/application-policy';
import { AuthenticationService } from '../service/authentication.service';
import { Application } from '../application-add/application-add.component';
import { MatPaginator } from '@angular/material';
import { Workflow } from '../model/workflow.model';
import { isRejected } from 'q';



// export interface PeriodicElement {
//   status: string;
//   applicationId: number;
//   age: number;
//   // symbol: string;
//   noofdependent: number;
//   sumassured: number;
//   premium: number;
//   years: number;

// }

// const ELEMENT_DATA: PeriodicElement[] = [
//   { applicationId: 1, status: 'Hydrogen', age: 1.0079, noofdependent: 2, sumassured: 1000000, premium: 5000, years: 5 },
//   { applicationId: 2, status: 'Helium', age: 4.0026, noofdependent: 2, sumassured: 1000000, premium: 5000, years: 5 },
//   { applicationId: 3, status: 'Lithium', age: 6.941, noofdependent: 2, sumassured: 1000000, premium: 5000, years: 5 },
//   { applicationId: 4, status: 'Beryllium', age: 9.0122, noofdependent: 2, sumassured: 1000000, premium: 5000, years: 5 },
//   { applicationId: 5, status: 'Boron', age: 10.811, noofdependent: 2, sumassured: 1000000, premium: 5000, years: 5 },
//   { applicationId: 6, status: 'Carbon', age: 12.0107, noofdependent: 2, sumassured: 1000000, premium: 5000, years: 5 },
//   { applicationId: 7, status: 'Nitrogen', age: 14.0067, noofdependent: 2, sumassured: 1000000, premium: 5000, years: 5 },
//   { applicationId: 8, status: 'Oxygen', age: 15.9994, noofdependent: 2, sumassured: 1000000, premium: 5000, years: 5 },
//   { applicationId: 9, status: 'Fluorine', age: 18.9984, noofdependent: 2, sumassured: 1000000, premium: 5000, years: 5 },
//   { applicationId: 10, status: 'Neon', age: 20.1797, noofdependent: 2, sumassured: 1000000, premium: 5000, years: 5 },
// ];

@Component({
  selector: 'app-application-view',
  templateUrl: './application-view.component.html',
  styleUrls: ['./application-view.component.css']
})
export class ApplicationViewComponent implements OnInit, AfterViewInit {
  displayedColumns: string[] = ['sumAssured', 'noOfYears', 'age', 'premium', 'salary', 'noOfDependents', 'status', 'workflow'];
  userid: number;
  applications: any = [];
  //  dataSource = new MatTableDataSource();
  dataSource: MatTableDataSource<any>;

  @ViewChild(MatSort, { static: true }) sort: MatSort;
  //  @ViewChild(MatSort, { static: true }) sort: MatSort;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  apps: any = [];
  workflows: Workflow[];



  constructor(private restService: RestService, private authService: AuthenticationService) { }

  ngOnInit() {
    //  this.dataSource.sort = this.sort;
    this.userid = this.authService.getUserId();
    // console.log(this.userid);
    var i = 0;
    this.restService.get<Application[]>('api/application/user/' + this.userid, null).subscribe(data => {
      data.forEach(res => {
        //var application = new Application("",1,1,1,null,1,"1l",1)
        var application = new Application(res.applicantname, res.sumAssured, res.noOfYears, res.age, res.dependents, res.premium, res.salary, res.noOfDependents);
        this.applications[i++] = application;
        this.dataSource = new MatTableDataSource(this.applications);
        //        this.creditAppDataSource = new MatTableDataSource
        //   this.dataSource.sort=this.sort;
        //    this.dataSource.paginator=this.paginator;
      })
    });
  }


  ngAfterViewInit() {
    //    this.dataSource.sort = this.sort;
    this.userid = this.authService.getUserId();
    // console.log(this.userid);
    var i = 0;
    this.restService.get<Application[]>('api/application/user/' + this.userid, null).subscribe(data => {
      this.applications = data;
      this.dataSource = new MatTableDataSource(this.applications);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
    });
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  showWorkflow(data) {

    // console.log("in workflow", data);

    // console.log(data.applicationId);
    this.workflows = [];
    this.restService.get<Workflow[]>('api/application/workflow/applicationId/' + data.applicationId, null).subscribe(data => {
      // console.log("current workflows: " + JSON.stringify(data));
      this.workflows = data;
    });
  }
  borderType(workflow: Workflow) {
    if (workflow.status === 'Auto approved') {
      return " alert-success";
    } else if (workflow.status === 'rejected') {
      return "alert-danger";
    } else {
      return "alert-info";
    }
  }
}
