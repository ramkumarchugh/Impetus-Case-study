import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { User } from '../model/user';


@Injectable({
    providedIn: 'root'
})
export class AuthenticationService {
    router: any;
    constructor(private http: HttpClient) {


    }

    authenticate(userEmail, password) {
        const headers = new HttpHeaders({
            Authorization: 'Basic ' + btoa(userEmail + ':' + password),
            'X-Requested-With': 'XMLHttpRequest'
        });
        return this.http.get<any>('api/user/authenticate', { headers }).pipe(
            map(
                userData => {
                    // console.log(userData);
                    localStorage.setItem('userEmail', userEmail);
                    localStorage.setItem('name', userData.name);
                    // console.log(userData.role.roleId);
                    localStorage.setItem('roleId', userData.role.roleId);
                    localStorage.setItem('user', JSON.stringify(userData));
                    return userData;
                }
            )
        );
    }

    isUserLoggedIn() {
        let user = localStorage.getItem('userEmail')
        // console.log(!(user === null))
        return !(user === null)
    }
    isUserAdmin() {
        let admin = localStorage.getItem('roleId')
        if (admin === '1') {
            // console.log(!(admin === null))
            return !(admin === null)
        }
        else {
            return false
        }
    }
    isUserUnderwriter(){
    let underwriter = localStorage.getItem('roleId')
    if(underwriter === '2')
    {
        // console.log(!(underwriter === null))
        return !(underwriter === null)
    }
    else{
        return false
    }
    }
    // isUserCustomer(){
    //     let customer = localStorage.getItem('roleId')
    //     if(customer === '3')
    //     {
    //         console.log(!(customer === null))
    //         return !(customer === null)
    //     }
    //      else{
    //         return false
    //     }   
    // }


    getUserId() {
        let user = <User>JSON.parse(localStorage.getItem('user'));
        return user != null ? user.userId : -1;
    }

    getUser() {
        let user = <User>JSON.parse(localStorage.getItem('user'));
        return user;
    }


    // public checkLogin(){
    //   let result = sessionStorage.getItem("currentUserResult");

    //   if(result === null)
    //   {
    //     this.router.navigate(['']);
    //   }

    //   else
    //   {
    //     let role = sessionStorage.getItem("result.role_id")

    //     if(role === '1'){
    //       this.router.navigate(['admin']);
    //     }

    //     if(role === '2'){
    //       this.router.navigate(['underwriter']);
    //     }

    //     if(role === '3'){
    //       this.router.navigate(['insurance/user']);
    //     }
    //   }

    // }

    logOut() {
        localStorage.removeItem('userEmail');
        localStorage.removeItem('user');
    }

}
