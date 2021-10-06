package amaciag.springframework.sfgpetclinic.repositories;

import amaciag.springframework.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;


public interface VetRepository extends CrudRepository<Vet, Long> {
}
