import {AbstractResponse} from "./abstract-response";
import {Competition} from "./competition";
import {User} from "./user";
import {Fish} from "./fish";

/**
 * Hunting interface represents a hunting entity, extending the AbstractEntity interface.
 * It encapsulates data related to a hunting event such as the number of fish caught,
 * the associated competition, user, and fish.
 */
export interface Hunting extends AbstractResponse {
  numberOfFish: number;
  competition?: Competition;
  user?: User;
  fish?: Fish;
}
