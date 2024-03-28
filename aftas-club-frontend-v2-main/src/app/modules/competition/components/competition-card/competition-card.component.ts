import {Component, Input, input} from '@angular/core';
import {Competition} from "../../../../core/models/competition";
import {CompetitionStatusDirective} from "../../directives/DateStatusDirective";
import {Store} from "@ngrx/store";
import {CompetitionPageActions} from "../../../../core/store/competition-state/actions/competition-page.actions";

@Component({
  selector: 'app-competition-card',
  standalone: true,
  imports: [
    CompetitionStatusDirective
  ],
  templateUrl: './competition-card.component.html',
  styleUrl: './competition-card.component.css'
})
export class CompetitionCardComponent {
  @Input() competition!: Competition;

  constructor(private store: Store) {
  }
  selectCompetition() {
    this.store.dispatch(CompetitionPageActions.selectCompetition({competition: this.competition}))
  }
}
