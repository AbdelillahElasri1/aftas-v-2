import { Injectable } from '@angular/core';
import {AbstractService} from "../abstract.service";
import {User} from "../../../core/models/user";
import {AuthenticationRequest} from "../../../core/models/requests/authentication-request";
import {Observable} from "rxjs";
import {AuthenticationResponse} from "../../../core/models/authentication-response";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../../environments/environment.development";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private api_url: string = environment.API_URL;
  constructor(private _http: HttpClient) {}

  /**
   * Sends an authentication request to the server.
   *
   * @param {AuthenticationRequest} request - The authentication request containing user credentials.
   * @returns {Observable<AuthenticationResponse>} An Observable emitting the authentication response.
   */
  authenticate(request: AuthenticationRequest): Observable<AuthenticationResponse> {
    return this._http.post<AuthenticationResponse>(`${this.api_url}/auth/authenticate`, request);
  }

  /**
   * Sends a registration request to the server.
   *
   * @param {AuthenticationRequest} request - The authentication request containing user credentials.
   * @returns {Observable<AuthenticationResponse>} An Observable emitting the authentication response.
   */
  register(request: User): Observable<AuthenticationResponse> {
    return this._http.post<AuthenticationResponse>(`${this.api_url}/auth/register`, request);
  }

  /**
   * Sends a member registration request to the server.
   *
   * @param {AuthenticationRequest} request - The authentication request containing user credentials.
   * @returns {Observable<AuthenticationResponse>} An Observable emitting the authentication response.
   */
  registerMember(request: User): Observable<AuthenticationResponse> {
    return this._http.post<AuthenticationResponse>(`${this.api_url}/auth/register/member`, request);
  }

  /**
   * Sends a jury registration request to the server.
   *
   * @param {AuthenticationRequest} request - The authentication request containing user credentials.
   * @returns {Observable<AuthenticationResponse>} An Observable emitting the authentication response.
   */
  registerJury(request: User): Observable<AuthenticationResponse> {
    return this._http.post<AuthenticationResponse>(`${this.api_url}/auth/register/jury`, request);
  }

  /**
   * Sends an admin registration request to the server.
   *
   * @param {AuthenticationRequest} request - The authentication request containing user credentials.
   * @returns {Observable<AuthenticationResponse>} An Observable emitting the authentication response.
   */
  registerAdmin(request: User): Observable<AuthenticationResponse> {
    return this._http.post<AuthenticationResponse>(`${this.api_url}/auth/register/admin`, request);
  }
}
