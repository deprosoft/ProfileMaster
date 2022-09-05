package com.bootcamp.profilemaster.domain.services;

import com.bootcamp.profilemaster.domain.entities.Portafolio;
import com.bootcamp.profilemaster.domain.gateways.PortafolioGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortafolioService {

    @Autowired
    private PortafolioGateway gateway;

    public List<Portafolio> getAll(){
        return gateway.getAll();
    }

    public Optional<Portafolio> getPortafolioById(int id){
        return gateway.getPortafolioById(id);
    }

    public Portafolio savePortafolio(Portafolio portafolio){
        return gateway.savePortafolio(portafolio);
    }

    public void deleteById(int id){
        gateway.deletePortafolioById(id);
    }

    public Optional<List<Portafolio>> getPortafolioContainsTecnology(String descripcion){

        return gateway.getPortafolioContainsTecnology(descripcion);
    }

    public Optional<List<Portafolio>> getPortafolioByYearsOfExperience(int aniosExperiencia){

        return gateway.getPortafolioByYearsOfExperience(aniosExperiencia);
    }

    public Optional<List<Portafolio>> getPortafoliosByWillingToChangeResidence(String dispuestoCambioResidencia){

        return gateway.getPortafoliosByWillingToChangeResidence(dispuestoCambioResidencia);
    }
}
