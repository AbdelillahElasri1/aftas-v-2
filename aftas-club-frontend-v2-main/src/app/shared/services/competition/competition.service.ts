import { Injectable } from '@angular/core';
import {Competition} from "../../../core/models/competition";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../../../environments/environment.development";

@Injectable({
  providedIn: 'root'
})

export class CompetitionService {

  constructor(private _http: HttpClient) {
  }
  private api_url = environment.API_URL;
  create(item: Competition): Observable<Competition> {
    return this._http.post<Competition>(`${this.api_url}/competitions/create`, item);
  }

  delete(id: string): Observable<void> {
    return this._http.delete<void>(`${this.api_url}/competitions/${id}/delete`);
  }

  getAll(): Observable<Competition[]> {
    return this._http.get<Competition[]>(`${this.api_url}/competitions`);
  }

  getAllPaged(page: number, size: number): Observable<Competition[]> {
    return this._http.get<Competition[]>(`${this.api_url}/competitions/paged?page=0&size=8`);
    // ${page != 0 ? page - 1 : page}
  }

  getById(id: string): Observable<Competition> {
    return this._http.get<Competition>(`${this.api_url}/competitions/${id}`);
  }

  update(id: string, item: Competition): Observable<Competition> {
    return this._http.patch<Competition>(`${this.api_url}/competitions/${id}/update`, item);
  }

}
