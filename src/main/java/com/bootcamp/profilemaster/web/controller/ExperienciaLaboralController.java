package com.bootcamp.profilemaster.web.controller;

import com.bootcamp.profilemaster.domain.entities.ExperienciaLaboral;
import com.bootcamp.profilemaster.domain.services.ExperienciaLaboralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/experiencialaboral")
public class ExperienciaLaboralController {

    @Autowired
    private ExperienciaLaboralService servicio;

    @GetMapping("/all")
    public ResponseEntity<List<ExperienciaLaboral>> getAll()
    {
        return new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienciaLaboral> getById(@PathVariable("id") int id)
    {
        return servicio.getExperienciaLaboralById(id).map(td -> new ResponseEntity<>(td,HttpStatus.OK)).
                orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<ExperienciaLaboral> save(@RequestBody ExperienciaLaboral experienciaLaboral)
    {
        return new ResponseEntity<>(servicio.saveExperienciaLaboral(experienciaLaboral),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id)
    {
        servicio.deleteById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
