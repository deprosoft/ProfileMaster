package com.bootcamp.profilemaster.web.controller;

import com.bootcamp.profilemaster.domain.entities.Portafolio;
import com.bootcamp.profilemaster.domain.services.PortafolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/portafolio")
public class PortafolioController {

    @Autowired
    private PortafolioService servicio;

    @GetMapping("/all")
    public ResponseEntity<List<Portafolio>> getAll()
    {
        return new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Portafolio> getById(@PathVariable("id") int id)
    {
        return servicio.getPortafolioById(id).map(td -> new ResponseEntity<>(td,HttpStatus.OK)).
                orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Portafolio> save(@RequestBody Portafolio portafolio)
    {
        return new ResponseEntity<>(servicio.savePortafolio(portafolio),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id)
    {
        servicio.deleteById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/tecnologias/{descripcion}")
    public ResponseEntity<Optional<List<Portafolio>>> getPortafolioContainsTecnology(@PathVariable("descripcion") String descripcion){
        return new ResponseEntity<>(servicio.getPortafolioContainsTecnology(descripcion), HttpStatus.OK);
    }

    @GetMapping("/aniosexperiencia/{aniosExperiencia}")
    public ResponseEntity<Optional<List<Portafolio>>> getPortafolioByYearsOfExperience(@PathVariable("aniosExperiencia") int aniosExperiencia){
        return new ResponseEntity<>(servicio.getPortafolioByYearsOfExperience(aniosExperiencia), HttpStatus.OK);
    }

    @GetMapping("/cambioresidencia/{dispuestoCambioResidencia}")
    public ResponseEntity<Optional<List<Portafolio>>> getPortafoliosByWillingToChangeResidence(@PathVariable("dispuestoCambioResidencia") String dispuestoCambioResidencia){
        return new ResponseEntity<>(servicio.getPortafoliosByWillingToChangeResidence(dispuestoCambioResidencia), HttpStatus.OK);
    }
}
