package com.bootcamp.profilemaster.web.controller;

import com.bootcamp.profilemaster.domain.entities.Usuario;
import com.bootcamp.profilemaster.domain.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService servicio;

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAll()
    {
        return new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") int id)
    {
        return servicio.getUsuarioById(id).map(td -> new ResponseEntity<>(td,HttpStatus.OK)).
                orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario)
    {
        return new ResponseEntity<>(servicio.saveUsuario(usuario),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id)
    {
        servicio.deleteById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/ciudad/{ciudad}")
    public ResponseEntity<Optional<List<Usuario>>> getUsuariosByZone(@PathVariable("ciudad") String ciudad){
        return new ResponseEntity<>(servicio.getUsuariosByZone(ciudad), HttpStatus.OK);
    }
}
