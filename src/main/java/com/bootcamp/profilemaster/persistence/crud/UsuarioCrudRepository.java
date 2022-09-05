package com.bootcamp.profilemaster.persistence.crud;

import com.bootcamp.profilemaster.persistence.models.UsuarioDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<UsuarioDAO, Integer> {

    Optional <List<UsuarioDAO>> findByCiudadContaining(String ciudad);
}
