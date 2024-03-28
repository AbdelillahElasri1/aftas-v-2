import { Timestamp } from 'rxjs';

/**
 * AbstractEntity interface represents the basic structure of an entity model.
 * It defines common properties shared among different entity types.
 */
export interface AbstractResponse {
  id: string;
  createdAt: Timestamp<any>;
  updatedAt: Timestamp<any>;
}
