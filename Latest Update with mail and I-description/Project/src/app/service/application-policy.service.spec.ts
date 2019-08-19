import { TestBed } from '@angular/core/testing';

import { ApplicationPolicyService } from './application-policy.service';

describe('ApplicationPolicyService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ApplicationPolicyService = TestBed.get(ApplicationPolicyService);
    expect(service).toBeTruthy();
  });
});
