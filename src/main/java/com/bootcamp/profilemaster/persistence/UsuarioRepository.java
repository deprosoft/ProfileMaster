package com.bootcamp.profilemaster.persistence;

import com.bootcamp.profilemaster.domain.entities.Usuario;
import com.bootcamp.profilemaster.domain.gateways.UsuarioGateway;
import com.bootcamp.profilemaster.persistence.crud.UsuarioCrudRepository;
import com.bootcamp.profilemaster.persistence.mappers.UsuarioMapper;
import com.bootcamp.profilemaster.persistence.models.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class UsuarioRepository implements UsuarioGateway {

    @Autowired
    private UsuarioCrudRepository crudRepository;
    @Autowired
    private UsuarioMapper mapper;

    public UsuarioRepository(UsuarioCrudRepository crudRepository, UsuarioMapper mapper){
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Usuario> getAll() {

        List<UsuarioDAO> lista = (List<UsuarioDAO>) crudRepository.findAll();

        List<Usuario> listaUsuarios = mapper.toUsuarios(lista);

        return listaUsuarios;
    }

    @Override
    public Optional<Usuario> getUsuarioById(int idUsuario) {
        return crudRepository.findById(idUsuario).map(td-> mapper.toUsuario(td));
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        UsuarioDAO dao = mapper.toUsuarioDAO(usuario);
        return mapper.toUsuario(crudRepository.save(dao));
    }

    @Override
    public void deleteUsuarioById(int idUsuario){
        crudRepository.deleteById(idUsuario);
    }

    @Override
    public Optional<List<Usuario>> getUsuariosByZone(String ciudad) {
        Optional<List<UsuarioDAO>> userDAO = crudRepository.findByCiudadContaining(ciudad);
        return Optional.of(mapper.toUsuarios(userDAO.get()));
    }
}
