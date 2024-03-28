import {createActionGroup, emptyProps, props} from "@ngrx/store";
import {AuthenticationResponse} from "../../../models/authentication-response";

const SOURCE = "Auth Api"

export const authApiActions = createActionGroup({
  source: SOURCE,
  events: {
    registerSuccess: props<{response: AuthenticationResponse}>(),
    registerFailure: props<{errors: {}}>(),
    loginSuccess: props<{response: AuthenticationResponse}>(),
    loginFailure: props<{errors: {}}>(),
    logoutSuccess: emptyProps(),
    logoutFailure: props<{errors: {}}>()
  }
})
