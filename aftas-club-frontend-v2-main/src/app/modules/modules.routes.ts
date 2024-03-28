import {Routes} from "@angular/router";
import {HomeComponent} from "./home/pages/home/home.component";
import {juryGuard} from "../core/guards/jury.guard";

export const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "auth",
    loadComponent: () => import("./auth/pages/base/base.component").then(c => c.BaseComponent),
    children: [
      {
        path: "",
        redirectTo: "login",
        pathMatch: "full"
      },
      {
        path: "login",
        loadComponent: () => import("./auth/pages/login/login.component").then(c => c.LoginComponent)
      },
      {
        path: "register",
        loadComponent: () => import("./auth/pages/register/register.component").then(c => c.RegisterComponent)
      }
    ]
  },
  {
    path: "competitions",
    loadComponent: () => import("./competition/pages/base/base.component").then(c => c.BaseComponent),
    canActivate: [juryGuard],
    children: [
      {
        path: "",
        redirectTo: "members",
        pathMatch: "full"
      },
      {
        path: "members",
        loadComponent: () => import("./member/pages/base/base.component").then(c => c.BaseComponent),
        children: [
          {
            path: "",
            loadComponent: () => import("./member/pages/members/members.component").then(c => c.MembersComponent)
          },
          {
            path: "create",
            loadComponent: () => import("./member/pages/member-creation-form/member-creation-form.component").then(c => c.MemberCreationFormComponent)
          }
        ]
      },
      {
        path: "podium",
        loadComponent: () => import("./competition/pages/competition-podium/competition-podium.component").then(c => c.CompetitionPodiumComponent)
      },
      {
        path: "create",
        loadComponent: () => import("./competition/pages/competition-creation-form/competition-creation-form.component").then(c => c.CompetitionCreationFormComponent)
      }
    ]
  },
  {
    path: "**",
    loadComponent: () => import("./errors/pages/not-found/not-found.component").then(c => c.NotFoundComponent)
  }
];
