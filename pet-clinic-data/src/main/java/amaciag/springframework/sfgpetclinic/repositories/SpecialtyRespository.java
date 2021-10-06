package amaciag.springframework.sfgpetclinic.repositories;

import amaciag.springframework.sfgpetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRespository extends CrudRepository<Specialty, Long> {
}
