import {AuthenticationResponse} from "../models/authentication-response";

export interface authStateInterface {
  user: AuthenticationResponse | null | undefined,
  isLoggedIn: boolean,
  isSubmitting: boolean,
  isLoading: boolean,
  errors: {}
}

interface decodeTokenInterface {
  "sub": string,
  "iat": number,
  "exp": number,
  "roles": []
}
