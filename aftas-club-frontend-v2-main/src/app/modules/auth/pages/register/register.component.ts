import { Component } from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {RouterLink} from "@angular/router";
import {Store} from "@ngrx/store";
import {UserRole} from "../../../../core/enums/user-role";
import {IdentityDocumentType} from "../../../../core/enums/identity-document-type";
import {authPageActions} from "../../../../core/store/auth/actions/auth-page.actions";
import {formatDate} from "@angular/common";

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    RouterLink
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  registerForm: FormGroup = new FormGroup({
    name: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.min(8)]),
    familyName: new FormControl('', [Validators.required]),
    accessionDate: new FormControl(formatDate(new Date(), "yyyy-MM-dd", "en"), [Validators.required]),
    nationality: new FormControl('', [Validators.required]),
    role: new FormControl('', [Validators.required]),
    identityDocument: new FormControl('', [Validators.required]),
    identityNumber: new FormControl('', [Validators.required])
  })
  constructor(private _store: Store) {
  }

  submit() {
    if (this.registerForm.valid) {
      this._store.dispatch(authPageActions.register({request: this.registerForm.value}));
    }else {
      alert("invalid")
    }
  }

  protected readonly UserRole = UserRole;
  protected readonly IdentityDocumentType = IdentityDocumentType;
}
