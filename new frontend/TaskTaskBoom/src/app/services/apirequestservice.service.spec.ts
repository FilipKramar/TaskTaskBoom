import { TestBed } from '@angular/core/testing';

import { ApirequestService } from './apirequestservice.service';

describe('ApirequestserviceService', () => {
  let service: ApirequestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApirequestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});