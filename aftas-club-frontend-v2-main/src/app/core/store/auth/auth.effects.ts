import {Actions, createEffect, ofType} from "@ngrx/effects";
import {inject} from "@angular/core";
import {AuthenticationService} from "../../../shared/services/authentication/authentication.service";
import {authPageActions} from "./actions/auth-page.actions";
import {catchError, concatMap, map, of, tap} from "rxjs";
import {authApiActions} from "./actions/auth-api.actions";
import {LocalStorageService} from "../../../shared/services/local-storage-service/local-storage.service";
import {UserRole} from "../../enums/user-role";
import {Router} from "@angular/router";

export const login$ = createEffect((
  actions$ = inject(Actions),
  authenticationService = inject(AuthenticationService),
  localStorageService = inject(LocalStorageService)
) => {
  return actions$.pipe(
    ofType(authPageActions.login),
    concatMap((action) => {
      return authenticationService.authenticate(action.request).pipe(
        map((response) => {
          localStorageService.setPersistState(response);
          return authApiActions.loginSuccess({
            response: response
          });
        }),
        catchError((errors) => {
          return of(
            authApiActions.loginFailure({errors: errors})
          )
        })
      )
    })
  )
}, {functional: true})

export const register$ = createEffect((
  actions$ = inject(Actions),
  authenticationService = inject(AuthenticationService),
  localStorageService = inject(LocalStorageService)
) => {
  return actions$.pipe(
    ofType(authPageActions.register),
    concatMap((action) => authenticationService.register(action.request).pipe(
      map((response) => {
        localStorageService.setPersistState(response);
        return authApiActions.registerSuccess({response: response});
      }),
      catchError((errors) => {
        return of(authApiActions.registerFailure({errors: errors}));
      })
    ))
  )
}, {functional: true})


/**
 * Redirection After Login or Register Effect
 *
 * this effect handles the process of redirections after a succesfull sign in or sign up by
 * intercepting the loginSuccess or registerSuccess action, and navigate to the appropriate route based
 * on the user's role.
 *
 * @param actions$ - The stream of actions in the application.
 * @param router - The injected Router service for navigation.
 * @returns An Observable with no dispatched actions (dispatch: false)
 */
export const redirectAfterLoginOrRegisterEffect = createEffect((
  actions$ = inject(Actions),
  router = inject(Router)
) => {
  return actions$.pipe(
    ofType(authApiActions.loginSuccess, authApiActions.registerSuccess, authPageActions.logout),
    tap((action) => {
      if (action.type !== "[Auth Page] logout") {
        if (action.response.role === UserRole.JURY) {
          router.navigateByUrl("/competitions");
        }else {
          router.navigateByUrl("/");
        }
      }else {
          router.navigateByUrl("/");
      }
    })
  )
}, {functional: true, dispatch: false});

