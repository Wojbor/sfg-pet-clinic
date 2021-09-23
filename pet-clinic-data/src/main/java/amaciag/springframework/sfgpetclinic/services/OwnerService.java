package amaciag.springframework.sfgpetclinic.services;

import amaciag.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);


}
