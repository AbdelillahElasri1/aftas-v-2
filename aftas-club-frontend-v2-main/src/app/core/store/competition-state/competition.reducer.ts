import {createFeature, createReducer, on} from "@ngrx/store";
import {CompetitionStateInterface} from "../../interfaces/competition-state-interface";
import {CompetitionPageActions} from "./actions/competition-page.actions";
import {CompetitionApiActions} from "./actions/competition-api.actions";

const COMPETITION_FEATURE_KEY = "Competition";

const initialState: CompetitionStateInterface = {
  competitions: [],
  selectedCompetition: null,
  errors: {},
  loading: false,
  pageInfo: {
    currentPage: 0,
    first: false,
    last: false,
    totalElements: 0,
    totalPages: 0
  }
}

const competitionFeature = createFeature({
  name: COMPETITION_FEATURE_KEY,
  reducer: createReducer(
    initialState,
    on(CompetitionPageActions.enter, state => ({
      ...state,
      loading: true
    })),
    on(CompetitionApiActions.competitionsLoadedSuccess, (state, action) => ({
      ...state,
      loading: false,
      competitions: action.competitions,
      pageInfo: action.pageInfo
    })),
    on(CompetitionApiActions.competitionsLoadedFailure, (state, action) => ({
      ...state,
      loading: false,
      errors: action.errors
    }))
  )
})

export const {
  name: competitionFeatureKey,
  reducer: competitionReducer,
  selectCompetitions,
  selectSelectedCompetition,
  selectLoading,
  selectErrors,
  selectPageInfo
} = competitionFeature;
