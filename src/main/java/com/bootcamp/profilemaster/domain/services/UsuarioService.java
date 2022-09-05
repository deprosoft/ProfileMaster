package com.bootcamp.profilemaster.domain.services;

import com.bootcamp.profilemaster.domain.entities.Usuario;
import com.bootcamp.profilemaster.domain.gateways.UsuarioGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioGateway gateway;

    public List<Usuario> getAll(){
        return gateway.getAll();
    }

    public Optional<Usuario> getUsuarioById(int id){
        return gateway.getUsuarioById(id);
    }

    public Usuario saveUsuario(Usuario usuario){
        return gateway.saveUsuario(usuario);
    }

    public void deleteById(int id){
        gateway.deleteUsuarioById(id);
    }

    public Optional<List<Usuario>> getUsuariosByZone(String ciudad){

        return gateway.getUsuariosByZone(ciudad);
    }
}
