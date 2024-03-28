import { Component } from '@angular/core';
import {TableComponent} from "../../../../shared/components/table/table.component";
import {GlobalPaginationComponent} from "../../../../shared/components/global-pagination/global-pagination.component";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-members',
  standalone: true,
  imports: [
    TableComponent,
    GlobalPaginationComponent,
    RouterLink
  ],
  templateUrl: './members.component.html',
  styleUrl: './members.component.css'
})
export class MembersComponent {

}
