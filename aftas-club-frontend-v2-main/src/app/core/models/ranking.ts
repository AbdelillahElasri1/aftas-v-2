import {RankId} from "../interfaces/rank-id";

/**
 * Ranking interface represents a ranking entity.
 * It encapsulates data related to a ranking such as id, rank, score, createdAt, and updatedAt.
 */
export interface Ranking {
  id: RankId;
  rank: number;
  score: number;
  createdAt: Date;
  updatedAt: Date;
}
