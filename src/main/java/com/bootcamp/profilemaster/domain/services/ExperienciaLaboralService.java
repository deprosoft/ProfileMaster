package com.bootcamp.profilemaster.domain.services;

import com.bootcamp.profilemaster.domain.entities.ExperienciaLaboral;
import com.bootcamp.profilemaster.domain.gateways.ExperienciaLaboralGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienciaLaboralService {

    @Autowired
    private ExperienciaLaboralGateway gateway;

    public List<ExperienciaLaboral> getAll(){
        return gateway.getAll();
    }

    public Optional<ExperienciaLaboral> getExperienciaLaboralById(int id){
        return gateway.getExperienciaLaboralById(id);
    }

    public ExperienciaLaboral saveExperienciaLaboral(ExperienciaLaboral experienciaLaboral){
        return gateway.saveExperienciaLaboral(experienciaLaboral);
    }

    public void deleteById(int id){
        gateway.deleteExperienciaLaboralById(id);
    }


}
