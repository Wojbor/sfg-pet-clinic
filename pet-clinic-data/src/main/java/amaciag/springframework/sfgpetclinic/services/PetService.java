package amaciag.springframework.sfgpetclinic.services;

import amaciag.springframework.sfgpetclinic.model.BaseEntity;
import amaciag.springframework.sfgpetclinic.model.Pet;

public interface PetService<P extends BaseEntity, L extends Number> extends CrudService<Pet, Long>{


}
