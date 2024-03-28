import {authStateInterface} from "../../interfaces/auth-state-interface";
import {ActionReducer, INIT, MetaReducer, UPDATE} from "@ngrx/store";
import {LocalStorageService} from "../../../shared/services/local-storage-service/local-storage.service";
import {inject} from "@angular/core";


const hydrationMetaReducer = (
  reducer: ActionReducer<authStateInterface>
): ActionReducer<authStateInterface> => {
  return (state, action) => {
    if (action.type === INIT || action.type === UPDATE) {
      const storageValue = localStorage.getItem("access");
      if (storageValue) {
        try {
          return JSON.parse(storageValue);
        } catch {
          localStorage.removeItem("access");
        }
      }
    }
    const nextState = reducer(state, action);
    localStorage.setItem("access", JSON.stringify(nextState));
    return nextState;
  };
}

export const metaReducers: MetaReducer<any>[] = [hydrationMetaReducer]
