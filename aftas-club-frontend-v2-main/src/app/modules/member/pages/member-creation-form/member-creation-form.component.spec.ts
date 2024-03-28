import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MemberCreationFormComponent } from './member-creation-form.component';

describe('MemberCreationFormComponent', () => {
  let component: MemberCreationFormComponent;
  let fixture: ComponentFixture<MemberCreationFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MemberCreationFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MemberCreationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
