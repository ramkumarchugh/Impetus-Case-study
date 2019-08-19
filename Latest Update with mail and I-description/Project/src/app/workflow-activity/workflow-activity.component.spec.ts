import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkflowActivityComponent } from './workflow-activity.component';

describe('WorkflowActivityComponent', () => {
  let component: WorkflowActivityComponent;
  let fixture: ComponentFixture<WorkflowActivityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WorkflowActivityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WorkflowActivityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
