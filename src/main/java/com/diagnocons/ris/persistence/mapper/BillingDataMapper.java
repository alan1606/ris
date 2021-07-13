package com.diagnocons.ris.persistence.mapper;

import com.diagnocons.ris.domain.dto.BillingData;
import com.diagnocons.ris.persistence.entity.DatosFacturacion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BillingDataMapper {

    @Mappings({
            @Mapping(source = "id", target = "idBillingData"),
            @Mapping(source = "razonSocial", target = "businessName"),
            @Mapping(source = "rfc", target = "rfc"),
            @Mapping(source = "cp", target = "cp"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "telefono", target = "phone")
    })
    BillingData toBillingData(DatosFacturacion datosFacturacion);
    List<BillingData> toBillingsDatas(List<DatosFacturacion> datosFacturacionList);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target="convenio", ignore=true),
            @Mapping(target="persona", ignore=true),
            @Mapping(target="ticketList", ignore=true)
    })
    DatosFacturacion toDatosFacturacion(BillingData billingData);

}
