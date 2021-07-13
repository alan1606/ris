package com.diagnocons.ris.persistence.repository;

import com.diagnocons.ris.domain.dto.BillingData;
import com.diagnocons.ris.domain.repository.BillingDataRepository;
import com.diagnocons.ris.persistence.crud.DatosFacturacionCrudRepository;
import com.diagnocons.ris.persistence.entity.DatosFacturacion;
import com.diagnocons.ris.persistence.mapper.BillingDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DatosFacturacionRepository implements BillingDataRepository {
    @Autowired
    private DatosFacturacionCrudRepository datosFacturacionCrudRepository;

    @Autowired
    private BillingDataMapper mapper;


    @Override
    public Optional<List<BillingData>> getAll() {
        List<DatosFacturacion> datos = (List<DatosFacturacion>) datosFacturacionCrudRepository.findAll();
        return Optional.of(mapper.toBillingsDatas(datos));
    }

    @Override
    public Optional<BillingData> getById(Long id) {
        return datosFacturacionCrudRepository.findById(id).map(datosFacturacion -> mapper.toBillingData(datosFacturacion));
    }

    @Override
    public Optional<BillingData> getByBusinessName(String businessName) {
        return datosFacturacionCrudRepository.findByRazonSocial(businessName).map(datosFacturacion -> mapper.toBillingData(datosFacturacion));
    }

    @Override
    public Optional<BillingData> getByRfc(String rfc) {
        return datosFacturacionCrudRepository.findByRfc(rfc).map(datosFacturacion -> mapper.toBillingData(datosFacturacion));
    }

    @Override
    public BillingData save(BillingData billingData) {
        DatosFacturacion datosFacturacion = mapper.toDatosFacturacion(billingData);
        return mapper.toBillingData(datosFacturacionCrudRepository.save(datosFacturacion));
    }

    @Override
    public boolean delete(Long id) {
        if(getById(id).isPresent()){
            datosFacturacionCrudRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
