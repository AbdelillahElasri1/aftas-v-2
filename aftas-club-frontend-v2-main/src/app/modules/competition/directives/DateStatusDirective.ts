import { Directive, Input, ElementRef, OnInit } from '@angular/core';

@Directive({
  standalone: true,
  selector: '[competitionStatus]'
})
export class CompetitionStatusDirective implements OnInit {
  @Input() competitionStatus!: {date: string, startTime: string, endTime: string};

  constructor(private el: ElementRef) {}

  ngOnInit() {
    const now = new Date();
    const startDate = new Date(`${this.competitionStatus.date}T${this.competitionStatus.startTime}`);
    const endDate = new Date(`${this.competitionStatus.date}T${this.competitionStatus.endTime}`);

    let status: string;
    if (now < startDate) {
      status = 'Upcoming';
      this.el.nativeElement.classList.add("text-blue-600")
    } else if (now > endDate) {
      status = 'Expired';
      this.el.nativeElement.classList.add("text-red-600")
    } else {
      status = 'Started';
      this.el.nativeElement.classList.add("text-green-600")
    }
    this.el.nativeElement.textContent = status;
  }
}
