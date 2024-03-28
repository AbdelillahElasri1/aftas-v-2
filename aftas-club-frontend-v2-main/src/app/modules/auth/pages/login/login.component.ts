import { Component } from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {Store} from "@ngrx/store";
import {authPageActions} from "../../../../core/store/auth/actions/auth-page.actions";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    RouterLink
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  loginForm: FormGroup = new FormGroup({
    email: new FormControl('', [Validators.email, Validators.required, Validators.max(50)]),
    password: new FormControl('', [Validators.required, Validators.min(8)])
  })

  constructor(private _store: Store) {
  }

  submit() {
    if (this.loginForm.valid) {
      this._store.dispatch(authPageActions.login({request: this.loginForm.value}))
    }else {
      console.log("form invalid")
    }
  }
}
