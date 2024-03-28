import {User} from "../models/user";
import {Competition} from "../models/competition";

/**
 * RankId interface represents the composite key for ranking entities.
 * It encapsulates data related to a ranking such as user and competition.
 */
export interface RankId {
  user: User;
  competition: Competition;
}
