package com.bootcamp.profilemaster.persistence;

import com.bootcamp.profilemaster.domain.entities.InformacionAcademica;
import com.bootcamp.profilemaster.domain.gateways.InformacionAcademicaGateway;
import com.bootcamp.profilemaster.persistence.crud.InformacionAcademicaCrudRepository;
import com.bootcamp.profilemaster.persistence.mappers.InformacionAcademicaMapper;
import com.bootcamp.profilemaster.persistence.models.InformacionAcademicaDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InformacionAcademicaRepository implements InformacionAcademicaGateway {

    private InformacionAcademicaCrudRepository crudRepository;
    private InformacionAcademicaMapper mapper;

    public InformacionAcademicaRepository(InformacionAcademicaCrudRepository crudRepository, InformacionAcademicaMapper mapper){
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<InformacionAcademica> getAll() {

        List<InformacionAcademicaDAO> lst = (List<InformacionAcademicaDAO>) crudRepository.findAll();

        List<InformacionAcademica> lstInformacionAcademicas = mapper.toInformacionAcademicas(lst);

        return lstInformacionAcademicas;
    }

    @Override
    public Optional<InformacionAcademica> getInformacionAcademicaById(int idInformacionAcademica) {
        return crudRepository.findById(idInformacionAcademica).map(td-> mapper.toInformacionAcademica(td));
    }

    @Override
    public InformacionAcademica saveInformacionAcademica(InformacionAcademica informacionAcademica) {
        InformacionAcademicaDAO dao = mapper.toInformacionAcademicaDAO(informacionAcademica);
        return mapper.toInformacionAcademica(crudRepository.save(dao));
    }

    @Override
    public void deleteInformacionAcademicaById(int idInformacionAcademica){
        crudRepository.deleteById(idInformacionAcademica);
    }

    @Override
    public Optional<List<InformacionAcademica>> getInformacionAcademicaByAcademicInformation(String descripcionInformacionAcademica) {
        Optional<List<InformacionAcademicaDAO>> userDAO = crudRepository.findByDescripcionInformacionAcademicaContaining(descripcionInformacionAcademica);
        return Optional.of(mapper.toInformacionAcademicas(userDAO.get()));
    }
}
