import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'; // Import HttpClientModule for HTTP requests
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { PurchaseBillComponent } from './purchase-bill/purchase-bill.component';
import { MessageComponent } from './message/message.component';
import { ContactComponent } from './contact/contact.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { DataService } from './myservice.service';
import { AdminComponent } from './admin/admin.component';
import { AdminLoginComponent } from './admin-login/admin-login.component'; // Import DataService


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    PurchaseBillComponent,
    MessageComponent,
    ContactComponent,
    AboutUsComponent,
    AdminComponent,
    AdminLoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
