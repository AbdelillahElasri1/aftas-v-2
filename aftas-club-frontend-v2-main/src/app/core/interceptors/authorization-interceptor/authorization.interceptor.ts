import { HttpInterceptorFn } from '@angular/common/http';
import {inject} from "@angular/core";
import {JwtService} from "../../../shared/services/jwt-service/jwt.service";

export const authorizationInterceptor: HttpInterceptorFn = (req, next) => {
  const token = inject(JwtService).getToken();

  if (req.url.includes("auth")) return next(req);
  const newReq = req.clone({
    headers: req.headers.set('Authorization', `Bearer ${token}`),
  });
  return next(newReq);
};
