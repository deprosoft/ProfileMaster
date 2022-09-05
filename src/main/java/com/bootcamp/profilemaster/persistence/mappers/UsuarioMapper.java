package com.bootcamp.profilemaster.persistence.mappers;

import com.bootcamp.profilemaster.domain.entities.Usuario;
import com.bootcamp.profilemaster.persistence.models.UsuarioDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ExperienciaLaboralMapper.class, InformacionAcademicaMapper.class, PortafolioMapper.class})
public interface UsuarioMapper {

    @Mappings({
            @Mapping(source = "idUsuario", target = "idUsuario"),
            @Mapping(source = "documento", target = "documento"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "apellido", target = "apellido"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "direccion", target = "direccion"),
            @Mapping(source = "fechaNacimiento", target = "fechaNacimiento"),
            @Mapping(source = "edad", target = "edad"),
            @Mapping(source = "hobbie", target = "hobbie")
    })

    Usuario toUsuario(UsuarioDAO dao);

    List<Usuario> toUsuarios(List<UsuarioDAO> daos);

    @InheritInverseConfiguration
    @Mapping(target = "portafolio", ignore = true )
    @Mapping(target = "experienciaLaboral", ignore = true )
    @Mapping(target = "informacionAcademica", ignore = true )
    UsuarioDAO toUsuarioDAO(Usuario dao);
}
