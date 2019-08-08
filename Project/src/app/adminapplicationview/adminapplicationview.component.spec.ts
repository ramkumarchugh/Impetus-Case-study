import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminapplicationviewComponent } from './adminapplicationview.component';

describe('AdminapplicationviewComponent', () => {
  let component: AdminapplicationviewComponent;
  let fixture: ComponentFixture<AdminapplicationviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminapplicationviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminapplicationviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
