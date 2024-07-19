import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  private apiUrl = 'http://localhost:8080/api/login'; // Replace with your API URL
  private loggedIn = new BehaviorSubject<boolean>(false);

  constructor(private http: HttpClient) { }

  // Getter for loggedIn observable
  get isLoggedIn(): Observable<boolean> {
    return this.loggedIn.asObservable();
  }

  // HTTP Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  // Login method
  login(username: string, password: string): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/login`, { username, password }, this.httpOptions)
      .pipe(
        map(response => {
          // Store login status in local storage or cookie
          localStorage.setItem('isLoggedIn', 'true');
          this.loggedIn.next(true);
          return response;
        })
      );
  }

  // Logout method
  logout() {
    // Remove login status from local storage or cookie
    localStorage.removeItem('isLoggedIn');
    this.loggedIn.next(false);
  }
}
