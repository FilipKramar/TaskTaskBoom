import { TestBed } from '@angular/core/testing';

import { ApirequestserviceService } from './apirequestservice.service';

describe('ApirequestserviceService', () => {
  let service: ApirequestserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApirequestserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
