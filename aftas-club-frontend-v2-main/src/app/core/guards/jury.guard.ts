import {CanActivateFn, Router} from '@angular/router';
import {inject} from "@angular/core";
import {JwtService} from "../../shared/services/jwt-service/jwt.service";
import {UserRole} from "../enums/user-role";

export const juryGuard: CanActivateFn = (route, state) => {
  const role = inject(JwtService).getRole();
  const router = inject(Router);
  if (role == UserRole.JURY) return true;
  else {
    router.navigateByUrl("/");
    return false;
  };
};
