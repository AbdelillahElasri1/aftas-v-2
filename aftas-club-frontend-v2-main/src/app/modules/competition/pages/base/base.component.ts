import {Component, OnInit} from '@angular/core';
import {SideBarComponent} from "../../components/side-bar/side-bar.component";
import {CompetitionNavComponent} from "../../components/competition-nav/competition-nav.component";
import {ActivatedRoute, RouterOutlet} from "@angular/router";
import {Store} from "@ngrx/store";
import {selectCompetitions} from "../../../../core/store/competition-state/competition.reducer";
import {CompetitionPageActions} from "../../../../core/store/competition-state/actions/competition-page.actions";
import {CompetitionService} from "../../../../shared/services/competition/competition.service";

@Component({
  selector: 'app-base',
  standalone: true,
  imports: [
    SideBarComponent,
    CompetitionNavComponent,
    RouterOutlet
  ],
  templateUrl: './base.component.html',
  styleUrl: './base.component.css'
})
export class BaseComponent implements OnInit {
  constructor(private activateRoute: ActivatedRoute, private store: Store, private compServ: CompetitionService) {
  }

  competitions = this.store.selectSignal(selectCompetitions);

  ngOnInit() {
    this.activateRoute.queryParams.subscribe(({page}) => {
      if (!page) page = 0;
      this.store.dispatch(CompetitionPageActions.enter({page: page, size: 8}));
    })
  }
}
