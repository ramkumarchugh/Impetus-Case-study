import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GenericPlanDetailsComponent } from './generic-plan-details.component';

describe('GenericPlanDetailsComponent', () => {
  let component: GenericPlanDetailsComponent;
  let fixture: ComponentFixture<GenericPlanDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GenericPlanDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GenericPlanDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
