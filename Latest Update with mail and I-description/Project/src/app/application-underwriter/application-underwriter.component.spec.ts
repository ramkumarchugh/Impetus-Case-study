import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplicationUnderwriterComponent } from './application-underwriter.component';

describe('ApplicationUnderwriterComponent', () => {
  let component: ApplicationUnderwriterComponent;
  let fixture: ComponentFixture<ApplicationUnderwriterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApplicationUnderwriterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApplicationUnderwriterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
