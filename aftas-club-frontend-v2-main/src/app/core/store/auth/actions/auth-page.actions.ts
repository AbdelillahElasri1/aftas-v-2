import {createActionGroup, emptyProps, props} from "@ngrx/store";
import {User} from "../../../models/user";
import {AuthenticationRequest} from "../../../models/requests/authentication-request";

const SOURCE = "Auth Page"

export const authPageActions = createActionGroup({
  source: SOURCE,
  events: {
    register: props<{request: User}>(),
    login: props<{request: AuthenticationRequest}>(),
    logout: emptyProps()
  }
})
