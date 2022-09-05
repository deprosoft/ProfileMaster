package com.bootcamp.profilemaster.web.controller;

import com.bootcamp.profilemaster.domain.entities.InformacionAcademica;
import com.bootcamp.profilemaster.domain.services.InformacionAcademicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/informacionacademica")
public class InformacionAcademicaController {

    @Autowired
    private InformacionAcademicaService servicio;

    @GetMapping("/all")
    public ResponseEntity<List<InformacionAcademica>> getAll()
    {
        return new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformacionAcademica> getById(@PathVariable("id") int id)
    {
        return servicio.getInformacionAcademicaById(id).map(td -> new ResponseEntity<>(td,HttpStatus.OK)).
                orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<InformacionAcademica> save(@RequestBody InformacionAcademica informacionAcademica)
    {
        return new ResponseEntity<>(servicio.saveInformacionAcademica(informacionAcademica),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id)
    {
        servicio.deleteById(id);
        return  new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/informacionacademica/{descripcionInformacionAcademica}")
    public ResponseEntity<Optional<List<InformacionAcademica>>> getInformacionAcademicasByAcademicInformation(@PathVariable("descripcionInformacionAcademica") String descripcionInformacionAcademica){
        return new ResponseEntity<>(servicio.getInformacionAcademicasByAcademicInformation(descripcionInformacionAcademica), HttpStatus.OK);
    }
}
