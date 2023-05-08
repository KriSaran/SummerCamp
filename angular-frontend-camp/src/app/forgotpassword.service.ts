import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ForgotpasswordService {
  
  apiUrl!: "http://localhost:8080/";
  

  constructor(private http:HttpClient) { }

  getForgotPassword(email: any): Observable<User> {
    return this.http.post(`${this.apiUrl}/forgot-password`, { email });
  }
}
