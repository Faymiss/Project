import { Component } from '@angular/core';
import { DataService } from '../myservice.service'; // Hakikisha njia ya kufikia huduma ya DataService

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {

  constructor(private dataService: DataService) {}

  ngOnInit(): void {
    this.loadData();
  }

  loadData(): void {
    this.dataService.getData().subscribe(
      (data: any) => {
        console.log('Fetched data in RegistrationComponent:', data);
        // Process data if needed
      },
      (error: any) => {
        console.error('Error fetching data in RegistrationComponent:', error);
        // Handle error loading data
      }
    );
  }
}
