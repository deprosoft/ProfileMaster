package com.bootcamp.profilemaster.persistence.mappers;

import com.bootcamp.profilemaster.domain.entities.Portafolio;
import com.bootcamp.profilemaster.persistence.models.PortafolioDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public interface PortafolioMapper {

    @Mappings({
            @Mapping(source = "idPortafolio", target = "idPortafolio"),
            @Mapping(source = "dispuestoCambioResidencia", target = "dispuestoCambioResidencia"),
            @Mapping(source = "aniosExperiencia", target = "aniosExperiencia"),
            @Mapping(source = "descripcion", target = "descripcion"),
            @Mapping(source = "idUsuario", target = "idUsuario")
    })

    Portafolio toPortafolio(PortafolioDAO dao);

    List<Portafolio> toPortafolios(List<PortafolioDAO> daos);

    @InheritInverseConfiguration
    @Mapping(target = "portafolioUsuario",ignore = true )
    PortafolioDAO toPortafolioDAO(Portafolio dao);
}
