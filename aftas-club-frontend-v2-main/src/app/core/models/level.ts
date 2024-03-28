import {AbstractResponse} from "./abstract-response";
import {Fish} from "./fish";

/**
 * Level interface represents a level entity, extending the AbstractEntity interface.
 * It encapsulates data related to a level such as description, points,
 * and a list of fish associated with the level.
 */
export interface Level extends AbstractResponse {
  description: string;
  points: number;
  fishList?: Fish[];
}
