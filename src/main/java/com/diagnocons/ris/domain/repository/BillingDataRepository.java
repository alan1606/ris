package com.diagnocons.ris.domain.repository;

import com.diagnocons.ris.domain.dto.BillingData;

import java.util.List;
import java.util.Optional;

public interface BillingDataRepository {
    Optional<List<BillingData>> getAll();
    Optional<BillingData> getById(Long id);
    Optional<BillingData> getByBusinessName(String businessName);
    Optional<BillingData> getByRfc(String rfc);
    BillingData save(BillingData billingData);
    boolean delete(Long id);
}
