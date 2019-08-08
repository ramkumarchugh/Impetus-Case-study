import { Component, OnInit, ViewChild } from '@angular/core';
import { UserService } from '../service/user.service';
import { MatTableDataSource, MatSort, MatPaginator } from '@angular/material';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {

 userColumns = ['userId','name','email','city','state','address','dob','mobNo'];
 UserDataSource = new MatTableDataSource([]);
  users: any =[];
  constructor(private userService: UserService) { }

 
  @ViewChild(MatSort, { static: true }) sort: MatSort;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  ngOnInit() {
    this.userService.getUsers().subscribe(response => {
      this.users = response;
      this.UserDataSource = new MatTableDataSource(this.users);
      // console.log("response from backend", JSON.stringify(this.UserDataSource.data));
      this.UserDataSource.sort = this.sort;
      this.UserDataSource.paginator = this.paginator;
    });
      //  this.handleSuccessfulResponse(response));
       

  }
 
   
  handleSuccessfulResponse(response) {
  console.log(JSON.stringify(response))   

  this.users = response;
}

}
