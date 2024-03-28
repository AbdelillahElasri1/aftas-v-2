import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {StoreModule} from "@ngrx/store";
import {competitionFeatureKey, competitionReducer} from "./competition.reducer";
import * as CompetitionsEffects from "./competition.effects";
import {EffectsModule} from "@ngrx/effects";



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    StoreModule.forFeature(competitionFeatureKey, competitionReducer),
    EffectsModule.forFeature(CompetitionsEffects)
  ]
})
export class CompetitionStateModule { }
