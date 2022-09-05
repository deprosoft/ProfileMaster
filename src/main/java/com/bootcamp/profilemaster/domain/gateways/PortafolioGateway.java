package com.bootcamp.profilemaster.domain.gateways;
import com.bootcamp.profilemaster.domain.entities.Portafolio;

import java.util.List;
import java.util.Optional;

public interface PortafolioGateway {

    List<Portafolio> getAll();
    Optional<Portafolio> getPortafolioById(int id);
    Portafolio savePortafolio(Portafolio portafolio);
    void deletePortafolioById(int id);

    Optional<List<Portafolio>> getPortafolioContainsTecnology(String descripcion);
    Optional<List<Portafolio>> getPortafolioByYearsOfExperience(int aniosExperiencia);
    Optional<List<Portafolio>> getPortafoliosByWillingToChangeResidence(String dispuestoCambioResidencia);
}
