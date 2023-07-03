import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  @Output() signUpClicked = new EventEmitter<void>();

  onSignUpClick() {
    this.signUpClicked.emit();
  }
}
