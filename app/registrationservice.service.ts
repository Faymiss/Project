import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  
  private baseUrl = 'http://localhost:8080/api/registrations'; // Adjust URL according to your backend API base URL

  constructor(private http: HttpClient) { }

  // Method to create a new registration
  createRegistration(registrationData: any): Observable<any> {
    const url = `${this.baseUrl}/registrations`;
    return this.http.post(url, registrationData)
      .pipe(
        catchError(this.handleError) // Handle errors using the private handleError method
      );
  }

  // Method to update an existing registration by ID
  updateRegistration(id: number, updatedRegistration: any): Observable<any> {
    const url = `${this.baseUrl}/registrations/${id}`;
    return this.http.put(url, updatedRegistration)
      .pipe(
        catchError(this.handleError) // Handle errors using the private handleError method
      );
  }

  // Method to delete a registration by ID
  deleteRegistration(id: number): Observable<any> {
    const url = `${this.baseUrl}/registrations/${id}`;
    return this.http.delete(url)
      .pipe(
        catchError(this.handleError) // Handle errors using the private handleError method
      );
  }

  // Method to retrieve a registration by ID
  getRegistrationById(id: number): Observable<any> {
    const url = `${this.baseUrl}/registrations/${id}`;
    return this.http.get(url)
      .pipe(
        catchError(this.handleError) // Handle errors using the private handleError method
      );
  }

  // Method to find a registration by email address
  findRegistrationByEmail(email: string): Observable<any> {
    const url = `${this.baseUrl}/registrations/email/${email}`;
    return this.http.get(url)
      .pipe(
        catchError(this.handleError) // Handle errors using the private handleError method
      );
  }

  // Method to find a registration by phone number
  findRegistrationByPhoneNo(phoneNo: string): Observable<any> {
    const url = `${this.baseUrl}/registrations/phone/${phoneNo}`;
    return this.http.get(url)
      .pipe(
        catchError(this.handleError) // Handle errors using the private handleError method
      );
  }

  // Private method to handle HTTP errors
  private handleError(error: any) {
    console.error('Error in RegistrationService:', error);
    return throwError(error); // Throw the error to be caught by the subscriber
  }
}
