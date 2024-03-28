import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GlobalPaginationComponent } from './global-pagination.component';

describe('GlobalPaginationComponent', () => {
  let component: GlobalPaginationComponent;
  let fixture: ComponentFixture<GlobalPaginationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GlobalPaginationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GlobalPaginationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
