import { Component, OnInit, ViewChild } from '@angular/core';
import { ApplicationPolicyService } from '../service/application-policy.service';
import { RestService } from '../service/rest.service';
import { AuthenticationService } from '../service/authentication.service';
import { User } from '../model/user';
import { MatTableDataSource, MatSort, MatPaginator } from '@angular/material';

@Component({
  selector: 'app-adminapplicationview',
  templateUrl: './adminapplicationview.component.html',
  styleUrls: ['./adminapplicationview.component.css']
})
export class AdminapplicationviewComponent implements OnInit {
  applications: any;
  policies:string[];
  displayedColumns = ['applicationId','user.name','sumAssured', 'noOfYears', 'age','salary', 'premium','status'];
  Uname: any;
  dataSource : MatTableDataSource<any>;
  @ViewChild(MatSort, { static: true }) sort: MatSort;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  userid: number;

  constructor(private policyService:ApplicationPolicyService, private restService: RestService, private authService: AuthenticationService,) { }

  ngOnInit() {
    
      this.policyService.ggetPolicy().subscribe(response=>this.handleSuccessfulResponse(response))
      //this.dataSource.sort = this.sort;
      this.userid = this.authService.getUserId();
      // console.log(this.userid);
      var i=0;
      this.restService.get<any>('api/application/', null).subscribe(data => {
          this.applications=data;
          this.Uname=User.name;
          // console.log(this.Uname);
          
          this.dataSource = new MatTableDataSource(this.applications);
          // console.log("Table Data", JSON.stringify(this.dataSource.data));
          // console.log("Table Data", JSON.stringify(this.dataSource.data[0].user.name));
          this.dataSource.sort = this.sort;
          this.dataSource.paginator = this.paginator;
      });
    
    
  }
  handleSuccessfulResponse(response){
    this.policies=response;
  }
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  
  

}
