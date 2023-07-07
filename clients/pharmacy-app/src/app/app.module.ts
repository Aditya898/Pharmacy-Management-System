import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './homepage/homepage.component';
import { FooterComponent } from './footer/footer.component';
import { SignupComponent } from './signup/signup.component';
import { AboutComponent } from './about/about.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AdminHomepageComponent } from './admin-homepage/admin-homepage.component';

const appRoutes:Routes=[
  {path:'', component: HomepageComponent},
  {path:'signup', component: SignupComponent},
  {path:'about', component: AboutComponent},
  {path:'admin_homepage', component: AdminHomepageComponent}
  
]


@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    FooterComponent,
    SignupComponent,
    AboutComponent,
    NavbarComponent,
    AdminHomepageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
