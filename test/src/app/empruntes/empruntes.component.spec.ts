import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpruntesComponent } from './empruntes.component';

describe('EmpruntesComponent', () => {
  let component: EmpruntesComponent;
  let fixture: ComponentFixture<EmpruntesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmpruntesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpruntesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
