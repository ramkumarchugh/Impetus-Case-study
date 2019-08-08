import { TestBed } from '@angular/core/testing';

import { UnderwriterAuthGuardService } from './underwriter-auth-guard.service';

describe('UnderwriterAuthGuardService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UnderwriterAuthGuardService = TestBed.get(UnderwriterAuthGuardService);
    expect(service).toBeTruthy();
  });
});
