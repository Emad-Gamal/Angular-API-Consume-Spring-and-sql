import { TestBed } from '@angular/core/testing';

import { CatApiServiceService } from './cat-api-service.service';

describe('CatApiServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CatApiServiceService = TestBed.get(CatApiServiceService);
    expect(service).toBeTruthy();
  });
});
