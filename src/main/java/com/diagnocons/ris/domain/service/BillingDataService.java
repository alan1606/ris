package com.diagnocons.ris.domain.service;

import com.diagnocons.ris.domain.dto.BillingData;
import com.diagnocons.ris.domain.repository.BillingDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingDataService {

    @Autowired
    private BillingDataRepository billingDataRepository;

    public Optional<List<BillingData>> getAll(){
        return billingDataRepository.getAll();
    }

    public  Optional<BillingData> getById(Long id){
        return billingDataRepository.getById(id);
    }

    public Optional<BillingData> getByBusinessName(String businessName){
        return billingDataRepository.getByBusinessName(businessName);
    }

    public Optional<BillingData> getByRfc(String rfc){
        return billingDataRepository.getByRfc(rfc);
    }

    public BillingData save(BillingData billingData){
        return billingDataRepository.save(billingData);
    }

    public boolean delete(Long id){
        return billingDataRepository.delete(id);
    }

}
