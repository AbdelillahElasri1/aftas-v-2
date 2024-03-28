import {ApplicationConfig, importProvidersFrom, isDevMode} from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideStore } from '@ngrx/store';
import { provideEffects } from '@ngrx/effects';
import { provideStoreDevtools } from '@ngrx/store-devtools';
import {AppModule} from "./app.module";
import {provideHttpClient, withInterceptors} from "@angular/common/http";
import {authorizationInterceptor} from "./core/interceptors/authorization-interceptor/authorization.interceptor";

export const appConfig: ApplicationConfig = {
  providers: [
    importProvidersFrom(AppModule),
    provideRouter(routes),
    provideStore(),
    provideEffects(),
    provideStoreDevtools({ maxAge: 25, logOnly: !isDevMode() }),
    provideHttpClient(
      withInterceptors([authorizationInterceptor])
    )
  ]
};
