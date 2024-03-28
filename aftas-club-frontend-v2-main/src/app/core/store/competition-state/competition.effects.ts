import {Actions, createEffect, ofType} from "@ngrx/effects";
import {inject} from "@angular/core";
import {CompetitionService} from "../../../shared/services/competition/competition.service";
import {CompetitionPageActions} from "./actions/competition-page.actions";
import {catchError, exhaustMap, map, mergeMap, of, switchMap} from "rxjs";
import {CompetitionApiActions} from "./actions/competition-api.actions";

export const loadCompetitions$ = createEffect((
  actions$ = inject(Actions),
  competitionService = inject(CompetitionService)
) => {
  return actions$.pipe(
    ofType(CompetitionPageActions.enter),
    exhaustMap((action) => {
      return competitionService.getAllPaged(action.page, action.size).pipe(
        map((response: any) => {
          console.log(" response", response)
          return CompetitionApiActions.competitionsLoadedSuccess({
            competitions: response.content,
            pageInfo: {
              currentPage: response.number,
              first: response.first,
              last: response.last,
              totalElements: response.totalElements,
              totalPages: response.totalPages
            }
          })
        }),
        catchError((errors) => {
          console.log("errors", errors)
          return of(CompetitionApiActions.competitionsLoadedFailure({errors: errors}))
        })
      );
    })
  )
}, {functional: true})
