import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FirstComponenetComponent } from './first-componenet.component';

describe('FirstComponenetComponent', () => {
  let component: FirstComponenetComponent;
  let fixture: ComponentFixture<FirstComponenetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FirstComponenetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FirstComponenetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
