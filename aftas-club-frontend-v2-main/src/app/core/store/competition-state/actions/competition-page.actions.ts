import {createActionGroup, emptyProps, props} from "@ngrx/store";
import {Competition} from "../../../models/competition";

const SOURCE = "Competition Page";

export const CompetitionPageActions = createActionGroup({
  source: SOURCE,
  events: {
    enter: props<{page: number, size: number}>(),
    selectCompetition: props<{competition: Competition}>()
  }
})
