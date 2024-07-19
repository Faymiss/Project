import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class ContactService {
  
  private apiUrl = 'http://localhost:8080/api/contacts'; // Replace with your API URL
  
  constructor(private http: HttpClient) { }
  
  // HTTP Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  // Error handling
  private handleError(error: any) {
    console.error('An error occurred:', error);
    return throwError(error);
  }

  // Create a new contact
  createContact(contact: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}`, contact, this.httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }
}
