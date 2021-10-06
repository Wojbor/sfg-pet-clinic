package amaciag.springframework.sfgpetclinic.repositories;

import amaciag.springframework.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRespository extends CrudRepository<Visit, Long> {
}
