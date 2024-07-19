import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class BillService {

  private apiUrl = 'http://localhost:8080/api/bills/create'; // Replace with your API URL

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

  // Create a new bill
  createBill(bill: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/create`, JSON.stringify(bill), this.httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }

  // Get all bills
  getAllBills(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/`)
      .pipe(
        catchError(this.handleError)
      );
  }

  // Get bill by ID
  getBillById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`)
      .pipe(
        catchError(this.handleError)
      );
  }

  // Update bill
  updateBill(id: number, bill: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, JSON.stringify(bill), this.httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }

  // Delete bill
  deleteBill(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`)
      .pipe(
        catchError(this.handleError)
      );
  }
}
