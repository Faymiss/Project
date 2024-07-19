import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { PurchaseBillComponent } from './purchase-bill/purchase-bill.component';
import { MessageComponent } from './message/message.component';
import { ContactComponent } from './contact/contact.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminComponent } from './admin/admin.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'register', component: RegistrationComponent },
  { path: 'paybill', component: PurchaseBillComponent },
  { path: 'billmessage', component: MessageComponent },
  { path: 'message', component: MessageComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'about', component: AboutUsComponent },
  { path: 'admin', component: AdminLoginComponent },
  { path: 'admindashboard', component: AdminComponent },
  { path: '**', redirectTo: '', pathMatch: 'full' } // Catch-all route
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
