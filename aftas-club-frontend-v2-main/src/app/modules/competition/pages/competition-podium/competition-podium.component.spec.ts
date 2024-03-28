import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompetitionPodiumComponent } from './competition-podium.component';

describe('CompetitionPodiumComponent', () => {
  let component: CompetitionPodiumComponent;
  let fixture: ComponentFixture<CompetitionPodiumComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompetitionPodiumComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CompetitionPodiumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
