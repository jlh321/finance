import { TestBed } from '@angular/core/testing';

import { AccountTransactionServiceService } from './account-transaction-service.service';

describe('AccountTransactionServiceService', () => {
  let service: AccountTransactionServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AccountTransactionServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
