import { Component } from '@angular/core';
import {CompetitionNavComponent} from "../../../competition/components/competition-nav/competition-nav.component";
import {RouterLink, RouterOutlet} from "@angular/router";
import {SideBarComponent} from "../../../competition/components/side-bar/side-bar.component";

@Component({
  selector: 'app-member-dashboard',
  standalone: true,
  imports: [
    CompetitionNavComponent,
    RouterOutlet,
    SideBarComponent,
    RouterLink
  ],
  templateUrl: './member-dashboard.component.html',
  styleUrl: './member-dashboard.component.css'
})
export class MemberDashboardComponent {

}
