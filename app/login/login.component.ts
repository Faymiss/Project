import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../myservice.service'; // Hakikisha njia ya kufikia huduma ya DataService
import { Subscriber } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  passwd: string = '';

  constructor(private router: Router, private dataService: DataService) {}

  onSubmit() {
    // Implement your login logic here, such as authentication with username and password.
    // For demonstration, I'm assuming basic authentication and redirecting to '/paybill' on successful login.
    if (this.username === 'yourUsername' && this.passwd === 'yourPassword') {
      this.router.navigate(['/paybill']);
    } else {
      // Handle invalid login
      alert('Invalid username or password');
    }
  }

  loadData(): void {
    this.dataService.getData().subscribe(
      (data: any) => {
        console.log('Fetched data in LoginComponent:', data);
        // Process data if needed
      },
      (error:any) => {
        console.error('Error fetching data in LoginComponent:', error);
        // Handle error loading data
      }
    );
  }
}
