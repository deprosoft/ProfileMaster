package com.bootcamp.profilemaster.domain.gateways;

import com.bootcamp.profilemaster.domain.entities.InformacionAcademica;
import com.bootcamp.profilemaster.domain.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface InformacionAcademicaGateway {

    List<InformacionAcademica> getAll();
    Optional<InformacionAcademica> getInformacionAcademicaById(int id);
    InformacionAcademica saveInformacionAcademica(InformacionAcademica informacionAcademica);
    void deleteInformacionAcademicaById(int id);

    Optional<List<InformacionAcademica>> getInformacionAcademicaByAcademicInformation(String descripcionInformacionAcademica);
}
