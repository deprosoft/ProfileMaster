package com.bootcamp.profilemaster.persistence.mappers;

import com.bootcamp.profilemaster.domain.entities.InformacionAcademica;
import com.bootcamp.profilemaster.persistence.models.InformacionAcademicaDAO;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InformacionAcademicaMapper {

    @Mappings({
            @Mapping(source = "idInformacionAcademica", target = "idInformacionAcademica"),
            @Mapping(source = "descripcionInformacionAcademica", target = "descripcionInformacionAcademica"),
            @Mapping(source = "institucion", target = "institucion"),
            @Mapping(source = "fechaInicio", target = "fechaInicio"),
            @Mapping(source = "fechaTermino", target = "fechaTermino"),
            @Mapping(source = "tipoEducacion", target = "tipoEducacion"),
            @Mapping(source = "idUsuario", target = "idUsuario")
    })

    InformacionAcademica toInformacionAcademica(InformacionAcademicaDAO dao);

    List<InformacionAcademica> toInformacionAcademicas(List<InformacionAcademicaDAO> daos);

    @InheritInverseConfiguration
    @Mapping(target = "usuarioInformacionAcademica",ignore = true )
    InformacionAcademicaDAO toInformacionAcademicaDAO(InformacionAcademica dao);
}
