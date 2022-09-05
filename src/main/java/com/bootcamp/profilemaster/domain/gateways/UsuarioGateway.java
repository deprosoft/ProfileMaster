package com.bootcamp.profilemaster.domain.gateways;

import com.bootcamp.profilemaster.domain.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioGateway {

    List<Usuario> getAll();
    Optional<Usuario> getUsuarioById(int id);
    Usuario saveUsuario(Usuario usuario);
    void deleteUsuarioById(int id);

    Optional <List<Usuario>> getUsuariosByZone(String ciudad);

}
