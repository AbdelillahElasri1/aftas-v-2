import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {StoreModule} from "@ngrx/store";
import {authFeatureKey, authFeatureReducer} from "./auth.reducer";
import {EffectsModule} from "@ngrx/effects";
import * as authenticationEffects from "./auth.effects";
import {metaReducers} from "./hydration.reducer";



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    StoreModule.forFeature(authFeatureKey, authFeatureReducer, {
      metaReducers: metaReducers,
    }),
    EffectsModule.forFeature(authenticationEffects)
  ]
})
export class AuthStateModule { }
