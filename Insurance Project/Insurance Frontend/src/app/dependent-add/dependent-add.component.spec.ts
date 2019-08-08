import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DependentAddComponent } from './dependent-add.component';

describe('DependentAddComponent', () => {
  let component: DependentAddComponent;
  let fixture: ComponentFixture<DependentAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DependentAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DependentAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
