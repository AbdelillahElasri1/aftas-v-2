import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompetitionNavComponent } from './competition-nav.component';

describe('CompetitionNavComponent', () => {
  let component: CompetitionNavComponent;
  let fixture: ComponentFixture<CompetitionNavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompetitionNavComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CompetitionNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
