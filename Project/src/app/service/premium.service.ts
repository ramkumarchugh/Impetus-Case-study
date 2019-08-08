import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Premium} from '../model/premium';
@Injectable({
  providedIn: 'root'
})
export class PremiumService {

 private registerUrl:string;
  constructor(private http:HttpClient) {
this.registerUrl='api/insurance/calculate_premium';
   }
public savePremium(premium:Premium){
  return this.http.post<Premium>(this.registerUrl,premium);
}
// getPremium(){
// return this.http.get<Premium[]>("http://localhost:8080/insurance/calculate_premium");
// }
}