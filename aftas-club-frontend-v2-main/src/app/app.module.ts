import {isDevMode, NgModule} from '@angular/core';
import { CommonModule } from '@angular/common';
import {AuthStateModule} from "./core/store/auth/auth-state.module";
import {StoreModule} from "@ngrx/store";
import {EffectsModule} from "@ngrx/effects";
import {StoreDevtoolsModule} from "@ngrx/store-devtools";
import {HttpClientModule} from "@angular/common/http";
import {CompetitionStateModule} from "./core/store/competition-state/competition-state.module";



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    HttpClientModule,
    StoreModule.forRoot(),
    EffectsModule.forRoot(),
    StoreDevtoolsModule.instrument({ maxAge: 25, logOnly: !isDevMode(), autoPause: true, trace: false, traceLimit: 75 }),
    AuthStateModule,
    CompetitionStateModule
  ]
})
export class AppModule { }
