import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User} from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
 private registerUrl:string;
 private getuserUrl:string;
  constructor(private http:HttpClient) {
this.registerUrl='api/user';

   }
public save(user:User){
  return this.http.post<User>(this.registerUrl,user); //refer registration ts
}
getUsers(){
  return this.http.get<User[]>("api/user"); //refer admin ts
}
}