import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private client: HttpClient) { }

  get<RT>(url: string, headers: HttpHeaders): Observable<RT> {
    return this.client.get<RT>(url, { headers: headers });
  }

  post<T>(url: string, body: T, headers: HttpHeaders): Observable<T> {
    // console.info(JSON.stringify(body));
    return this.client.post<T>(url, body, { headers: headers });
  }
  put<T>(url: string, body: T, headers:HttpHeaders): Observable<T>
  {
    return this.client.put<T>(url, body, {headers: headers})
  }
}
