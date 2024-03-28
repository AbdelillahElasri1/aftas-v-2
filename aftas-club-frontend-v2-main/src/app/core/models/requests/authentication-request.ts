/**
 * Interface representing the data sent when a user is trying to authenticate.
 * This includes the user's email and password.
 *
 * @param email - The user's email address.
 * @param password - The user's password.
 */
export interface AuthenticationRequest {
  email: string;
  password: string;
}

