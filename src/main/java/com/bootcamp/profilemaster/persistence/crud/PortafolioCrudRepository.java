package com.bootcamp.profilemaster.persistence.crud;

import com.bootcamp.profilemaster.persistence.models.PortafolioDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PortafolioCrudRepository extends CrudRepository<PortafolioDAO, Integer> {

    Optional<List<PortafolioDAO>> findByDescripcionContaining(String descripcion);
    Optional<List<PortafolioDAO>> findByAniosExperienciaGreaterThanEqualOrderByAniosExperienciaAsc(int aniosExperiencia);

    Optional<List<PortafolioDAO>> findByDispuestoCambioResidenciaIgnoreCase(String dispuestoCambioResidencia);
}
