import {Competition} from "../models/competition";
import {PageInfo} from "./page-info";

export interface CompetitionStateInterface {
  competitions: Competition[] | null | undefined,
  selectedCompetition: Competition | null,
  loading: boolean,
  errors: {},
  pageInfo: PageInfo
}
