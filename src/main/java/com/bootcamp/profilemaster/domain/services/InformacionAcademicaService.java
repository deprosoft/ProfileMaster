package com.bootcamp.profilemaster.domain.services;

import com.bootcamp.profilemaster.domain.entities.InformacionAcademica;
import com.bootcamp.profilemaster.domain.gateways.InformacionAcademicaGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformacionAcademicaService {

    @Autowired
    private InformacionAcademicaGateway gateway;

    public List<InformacionAcademica> getAll(){
        return gateway.getAll();
    }

    public Optional<InformacionAcademica> getInformacionAcademicaById(int id){
        return gateway.getInformacionAcademicaById(id);
    }

    public InformacionAcademica saveInformacionAcademica(InformacionAcademica informacionAcademica){
        return gateway.saveInformacionAcademica(informacionAcademica);
    }

    public void deleteById(int id){
        gateway.deleteInformacionAcademicaById(id);
    }

    public Optional<List<InformacionAcademica>> getInformacionAcademicasByAcademicInformation(String descripcionInformacionAcademica){

        return gateway.getInformacionAcademicaByAcademicInformation(descripcionInformacionAcademica);
    }
}
