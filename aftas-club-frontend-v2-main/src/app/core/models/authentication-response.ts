/**
 * Interface representing the response for authentication.
 * Contains access and refresh tokens.
 */

export interface AuthenticationResponse {
  username?: string,
  email?: string,
  role?: string,
  access_token: string,
  refresh_token: string
  // decodedToken: decodeTokenInterface
}
