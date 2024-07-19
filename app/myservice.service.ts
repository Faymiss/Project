import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'  // Hii inahakikisha huduma inapatikana kwa njia ya programu yako yote
})
export class DataService {

  constructor() { }

  getData(): Observable<any> {
    return this.getData()
  }

  postData(data: any) {
    // Kazi ya kutuma data
  }
}
