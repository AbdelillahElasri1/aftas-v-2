import { Injectable } from '@angular/core';
import {authStateInterface} from "../../../core/interfaces/auth-state-interface";
import {JwtService} from "../jwt-service/jwt.service";
import {jwtDecode} from "jwt-decode";

@Injectable({
  providedIn: 'root'
})
export class LocalStorageService {

  constructor(private jwtService: JwtService) { }

  private readonly localStorageKey = 'access';

  setPersistState(data: any) {
    if (data != null) localStorage.setItem(this.localStorageKey, JSON.stringify(this.fillPersist(data)));
    else localStorage.setItem(this.localStorageKey, JSON.stringify(this.createEmptyPersist()));
  }

  getPersistState() {
    const data = localStorage.getItem(this.localStorageKey);
    return data ? JSON.parse(data) : null;
  }

  clearPersistState() {
    localStorage.removeItem(this.localStorageKey);
  }

  fillPersist(data: any): authStateInterface {
    return {
      errors: data.errors,
      user: data.user,
      isLoading: data.isLoading,
      isSubmitting: data.isSubmitting,
      isLoggedIn: data.isLoggedIn
    };
  }
  createEmptyPersist(): authStateInterface {
    return {
      user: null,
      isLoggedIn: false,
      isSubmitting: false,
      isLoading: false,
      errors: {}
    };
  }
}
