package com.bootcamp.profilemaster.persistence.crud;

import com.bootcamp.profilemaster.persistence.models.InformacionAcademicaDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface InformacionAcademicaCrudRepository extends CrudRepository<InformacionAcademicaDAO, Integer> {

    Optional<List<InformacionAcademicaDAO>> findByDescripcionInformacionAcademicaContaining(String descripcionInformacionAcademica);
}
