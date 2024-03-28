import {AbstractResponse} from "./abstract-response";
import {Hunting} from "./hunting";
import {Ranking} from "./ranking";
import {IdentityDocumentType} from "../enums/identity-document-type";
import {UserRole} from "../enums/user-role";

/**
 * User interface represents a user entity, extending the AbstractEntity interface.
 * It encapsulates data related to a user such as name, email, password, family name,
 * accession date, nationality, role, identity document type, identity number,
 * hunts list, and rankings.
 */
export interface User extends AbstractResponse {
  name: string;
  email: string;
  password: string;
  familyName: string;
  accessionDate: Date;
  nationality: string;
  role: UserRole;
  identityDocument: IdentityDocumentType;
  identityNumber: string;
  huntsList?: Hunting[];
  rankings?: Ranking[];
}
