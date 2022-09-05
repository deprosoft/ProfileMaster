package com.bootcamp.profilemaster.persistence.mappers;

import com.bootcamp.profilemaster.domain.entities.ExperienciaLaboral;
import com.bootcamp.profilemaster.persistence.models.ExperienciaLaboralDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ExperienciaLaboralMapper {

    @Mappings({
            @Mapping(source = "idExperienciaLaboral", target = "idExperienciaLaboral"),
            @Mapping(source = "descripcionExperienciaLaboral", target = "descripcionExperienciaLaboral"),
            @Mapping(source = "empresa", target = "empresa"),
            @Mapping(source = "fechaInicio", target = "fechaInicio"),
            @Mapping(source = "fechaTermino", target = "fechaTermino"),
            @Mapping(source = "idUsuario", target = "idUsuario")
    })

    ExperienciaLaboral toExperienciaLaboral(ExperienciaLaboralDAO dao);

    List<ExperienciaLaboral> toExperienciaLaborales(List<ExperienciaLaboralDAO> daos);

    @InheritInverseConfiguration
    @Mapping(target = "usuarioExpLaboral",ignore = true )
    ExperienciaLaboralDAO toExperienciaLaboralDAO(ExperienciaLaboral dao);
}
