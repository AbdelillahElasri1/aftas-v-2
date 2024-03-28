import {AbstractResponse} from "./abstract-response";
import {Hunting} from "./hunting";
import {Level} from "./level";

/**
 * Fish interface represents a fish entity, extending the AbstractEntity interface.
 * It encapsulates data related to a fish such as name, average weight,
 * and its associated hunts and level.
 */
export interface Fish extends AbstractResponse {
  name: string;
  averageWeight: number;
  huntsList?: Hunting[];
  level?: Level;
}
