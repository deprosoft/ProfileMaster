package com.bootcamp.profilemaster.domain.gateways;

import com.bootcamp.profilemaster.domain.entities.ExperienciaLaboral;

import java.util.List;
import java.util.Optional;

public interface ExperienciaLaboralGateway {

    List<ExperienciaLaboral> getAll();
    Optional<ExperienciaLaboral> getExperienciaLaboralById(int id);
    ExperienciaLaboral saveExperienciaLaboral(ExperienciaLaboral experienciaLaboral);
    void deleteExperienciaLaboralById(int id);

}
