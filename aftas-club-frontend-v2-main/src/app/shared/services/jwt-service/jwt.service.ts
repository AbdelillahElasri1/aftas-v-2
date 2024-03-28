import { Injectable } from '@angular/core';
import {jwtDecode} from "jwt-decode";
import {Store} from "@ngrx/store";
import {selectUser} from "../../../core/store/auth/auth.reducer";

@Injectable({
  providedIn: 'root'
})
export class JwtService {

  constructor(private store: Store) { }

  getToken() {
    const authenticationState = this.store.selectSignal(selectUser);
    return authenticationState() ? authenticationState()?.access_token : null;
  }

  getRefreshToken() {
    const authenticationState = this.store.selectSignal(selectUser);
    return authenticationState() ? authenticationState()?.refresh_token : null;
  }

  getUsername() {
    const authenticationState = this.store.selectSignal(selectUser);
    return authenticationState() ?? authenticationState()?.username;
  }

  getRole(){
    const authenticationState = this.store.selectSignal(selectUser);
    return authenticationState() ? authenticationState()?.role : null;
  }

  decodeJwt(token: any) {
    return jwtDecode(token);
  }
}
