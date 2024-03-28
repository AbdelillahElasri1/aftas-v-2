import {AbstractResponse} from "./abstract-response";
import {Hunting} from "./hunting";
import {Ranking} from "./ranking";

/**
 * Competition interface represents a competition entity, extending the AbstractEntity interface.
 * It encapsulates data related to a competition such as date, start time, end time,
 * number of participants, location, and amount.
 */
export interface Competition extends AbstractResponse {
  date: Date;
  startTime: Date;
  endTime: Date;
  numberOfParticipants: number;
  location: string;
  amount: number;
  huntsList?: Hunting[];
  ranksList?: Ranking[];
}
