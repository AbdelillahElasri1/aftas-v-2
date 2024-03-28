import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompetitionCreationFormComponent } from './competition-creation-form.component';

describe('CompetitionCreationFormComponent', () => {
  let component: CompetitionCreationFormComponent;
  let fixture: ComponentFixture<CompetitionCreationFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompetitionCreationFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CompetitionCreationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
