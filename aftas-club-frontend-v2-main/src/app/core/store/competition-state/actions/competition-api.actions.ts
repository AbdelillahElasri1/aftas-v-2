import {createActionGroup, props} from "@ngrx/store";
import {Competition} from "../../../models/competition";
import {PageInfo} from "../../../interfaces/page-info";

const SOURCE = "Competition Api";

export const CompetitionApiActions = createActionGroup({
  source: SOURCE,
  events: {
    competitionsLoadedSuccess: props<{competitions: Competition[], pageInfo: PageInfo}>(),
    competitionsLoadedFailure: props<{errors: {}}>(),
  }
})
