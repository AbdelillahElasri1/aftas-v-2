import {Component, Input} from '@angular/core';
import {RouterLink, RouterLinkActive} from "@angular/router";
import {routesType} from "../../../../shared/types/routesType";
import {selectSelectedCompetition} from "../../../../core/store/competition-state/competition.reducer";
import {Store} from "@ngrx/store";
import {authPageActions} from "../../../../core/store/auth/actions/auth-page.actions";

@Component({
  selector: 'app-competition-nav',
  standalone: true,
  imports: [
    RouterLink,
    RouterLinkActive
  ],
  templateUrl: './competition-nav.component.html',
  styleUrl: './competition-nav.component.css'
})
export class CompetitionNavComponent {
  activeRouterLinkStyle: string = "border-blue-500 text-blue-500 dark:text-white dark:border-white";

  constructor(private store: Store) {
  }

  competition = this.store.selectSignal(selectSelectedCompetition);

  routes: routesType[] = [
    {
      id: 1,
      to: "members",
      label: "members"
    },
    {
      id: 1,
      to: "ranks",
      label: "ranks"
    },
    {
      id: 1,
      to: "podium",
      label: "podium"
    },
  ]

  logout() {
    this.store.dispatch(authPageActions.logout());
  }
}
