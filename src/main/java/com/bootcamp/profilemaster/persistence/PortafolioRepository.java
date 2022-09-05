package com.bootcamp.profilemaster.persistence;

import com.bootcamp.profilemaster.domain.entities.Portafolio;
import com.bootcamp.profilemaster.domain.gateways.PortafolioGateway;
import com.bootcamp.profilemaster.persistence.crud.PortafolioCrudRepository;
import com.bootcamp.profilemaster.persistence.mappers.PortafolioMapper;
import com.bootcamp.profilemaster.persistence.models.PortafolioDAO;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class PortafolioRepository implements PortafolioGateway {

    private PortafolioCrudRepository crudRepository;
    private PortafolioMapper mapper;

    public PortafolioRepository(PortafolioCrudRepository crudRepository, PortafolioMapper mapper){
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Portafolio> getAll() {

        List<PortafolioDAO> lst = (List<PortafolioDAO>) crudRepository.findAll();

        List<Portafolio> lstPortafolios = mapper.toPortafolios(lst);

        return lstPortafolios;
    }

    @Override
    public Optional<Portafolio> getPortafolioById(int idPortafolio) {
        return crudRepository.findById(idPortafolio).map(td-> mapper.toPortafolio(td));
    }

    @Override
    public Portafolio savePortafolio(Portafolio portafolio) {
        PortafolioDAO dao = mapper.toPortafolioDAO(portafolio);
        return mapper.toPortafolio(crudRepository.save(dao));
    }

    @Override
    public void deletePortafolioById(int idPortafolio){
        crudRepository.deleteById(idPortafolio);
    }

    @Override
    public Optional<List<Portafolio>> getPortafolioContainsTecnology(String descripcion) {
        Optional<List<PortafolioDAO>> portafolioDAO = crudRepository.findByDescripcionContaining(descripcion);
        return Optional.of(mapper.toPortafolios(portafolioDAO.get()));
    }

    @Override
    public Optional<List<Portafolio>> getPortafolioByYearsOfExperience(int aniosExperiencia) {
        Optional<List<PortafolioDAO>> userDAO = crudRepository.findByAniosExperienciaGreaterThanEqualOrderByAniosExperienciaAsc(aniosExperiencia);
        return Optional.of(mapper.toPortafolios(userDAO.get()));
    }

    @Override
    public Optional<List<Portafolio>> getPortafoliosByWillingToChangeResidence(String dispuestoCambioResidencia) {
        Optional<List<PortafolioDAO>> userDAO = crudRepository.findByDispuestoCambioResidenciaIgnoreCase(dispuestoCambioResidencia);
        return Optional.of(mapper.toPortafolios(userDAO.get()));
    }
}
