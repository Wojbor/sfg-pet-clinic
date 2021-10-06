package amaciag.springframework.sfgpetclinic.services.springdatajpa;


import amaciag.springframework.sfgpetclinic.model.Visit;
import amaciag.springframework.sfgpetclinic.repositories.VisitRespository;
import amaciag.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class VisitSDJPAService implements VisitService {

    private final VisitRespository visitRespository;

    public VisitSDJPAService(VisitRespository visitRespository) {
        this.visitRespository = visitRespository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();

        visitRespository.findAll().forEach(visits::add);

        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRespository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRespository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRespository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        visitRespository.deleteById(aLong);

    }
}
