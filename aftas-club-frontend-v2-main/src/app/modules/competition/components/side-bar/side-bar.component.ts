import {Component, Input, input} from '@angular/core';
import {PaginationComponent} from "../../../../shared/components/pagination/pagination.component";
import {CompetitionCardComponent} from "../competition-card/competition-card.component";

@Component({
  selector: 'app-side-bar',
  standalone: true,
  imports: [
    PaginationComponent,
    CompetitionCardComponent
  ],
  templateUrl: './side-bar.component.html',
  styleUrl: './side-bar.component.css'
})
export class SideBarComponent {
  @Input({alias: "competitions", required: true}) competitions!: any;
}
