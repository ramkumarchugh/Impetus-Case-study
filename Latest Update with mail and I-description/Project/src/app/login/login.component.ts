import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
// export class LoginComponent implements OnInit {

//   constructor() { }

//   ngOnInit() {
//   }

// }
export class LoginComponent implements OnInit {
  userEmail = ''
  password = ''
  invalidLogin = false
  showMsg: boolean=false;

  constructor(private router: Router,
    private loginservice: AuthenticationService) { }
  submitUser(form) { //onsubmit
    // console.log(form.value);
    alert("The form was submitted");
    form.reset();
  }
  ngOnInit() {
    
  }

  checkLogin() {
    (this.loginservice.authenticate(this.userEmail, this.password).subscribe(
      data => {
this.showMsg=true;
        // console.log(data);
       // this.router.navigate(['/insurance/user']);
        
        this.invalidLogin = false
        let result = localStorage.getItem("roleId");
        // console.log('success',result);

        if(result === null)
        {
          this.router.navigate(['']);
        }
        else
        {
          let role = localStorage.getItem("roleId")

          if(role === '1'){
            this.router.navigate(['insurance/admin']);
          }

          if(role === '2'){
            // console.log('============',role);
            this.router.navigate(['insurance/underwriter']);
          }

          if(role === '3'){
            this.router.navigate(['insurance/user']);
            // console.log("in role 3");
          }
        }

      },
      error => {
        alert("Invalid credential, Please Try again");
        this.invalidLogin = true
        // console.log("invalid credential");

        // console.log(error);



      }
    )
    );

  }
}
