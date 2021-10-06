package amaciag.springframework.sfgpetclinic.repositories;

import amaciag.springframework.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
