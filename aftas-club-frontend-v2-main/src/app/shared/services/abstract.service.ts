import {inject, Injectable} from '@angular/core';
import {_Service} from "./_service";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment.development";

@Injectable({
  providedIn: 'root'
})
export class AbstractService<T> implements _Service<T>{
  private api_url = environment.API_URL;
  protected readonly resource!: string;

  constructor(private _http: HttpClient) {
  }

  create(item: T): Observable<T> {
    return this._http.post<T>(`${this.api_url}/${this.resource}/create`, item);
  }

  delete(id: string): Observable<void> {
    return this._http.delete<void>(`${this.api_url}/${this.resource}/${id}/delete`);
  }

  getAll(): Observable<T[]> {
    return this._http.get<T[]>(`${this.api_url}/${this.resource}`);
  }

  getAllPaged(page: number, size: number): Observable<T[]> {
    return this._http.get<T[]>(`${this.api_url}/${this.resource}/paged?page=${page ?? 0}&size=${size ?? 8}`);
  }

  getById(id: string): Observable<T> {
    return this._http.get<T>(`${this.api_url}/${this.resource}/${id}`);
  }

  update(id: string, item: T): Observable<T> {
    return this._http.patch<T>(`${this.api_url}/${this.resource}/${id}/update`, item);
  }
}
