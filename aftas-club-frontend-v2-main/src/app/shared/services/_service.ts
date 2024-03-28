import { Observable } from 'rxjs';

export interface _Service<T> {
  getAll(): Observable<T[]>;
  getAllPaged(page: number, size: number): Observable<T[]>;
  getById(id: string): Observable<T>;
  create(item: T): Observable<T>;
  update(id: string, item: T): Observable<T>;
  delete(id: string): Observable<void>;
}
