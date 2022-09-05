package com.bootcamp.profilemaster.persistence;

import com.bootcamp.profilemaster.domain.entities.ExperienciaLaboral;
import com.bootcamp.profilemaster.domain.gateways.ExperienciaLaboralGateway;
import com.bootcamp.profilemaster.persistence.crud.ExperienciaLaboralCrudRepository;
import com.bootcamp.profilemaster.persistence.mappers.ExperienciaLaboralMapper;
import com.bootcamp.profilemaster.persistence.models.ExperienciaLaboralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExperienciaLaboralRepository implements ExperienciaLaboralGateway {

    private ExperienciaLaboralCrudRepository crudRepository;
    private ExperienciaLaboralMapper mapper;

    public ExperienciaLaboralRepository(ExperienciaLaboralCrudRepository crudRepository, ExperienciaLaboralMapper mapper){
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ExperienciaLaboral> getAll() {

        List<ExperienciaLaboralDAO> lst = (List<ExperienciaLaboralDAO>) crudRepository.findAll();

        List<ExperienciaLaboral> lstExperienciaLaborales = mapper.toExperienciaLaborales(lst);

        return lstExperienciaLaborales;
    }

    @Override
    public Optional<ExperienciaLaboral> getExperienciaLaboralById(int idExperienciaLaboral) {
        return crudRepository.findById(idExperienciaLaboral).map(td-> mapper.toExperienciaLaboral(td));
    }

    @Override
    public ExperienciaLaboral saveExperienciaLaboral(ExperienciaLaboral experienciaLaboral) {
        ExperienciaLaboralDAO dao = mapper.toExperienciaLaboralDAO(experienciaLaboral);
        return mapper.toExperienciaLaboral(crudRepository.save(dao));
    }

    @Override
    public void deleteExperienciaLaboralById(int idExperienciaLaboral){
        crudRepository.deleteById(idExperienciaLaboral);
    }

}
