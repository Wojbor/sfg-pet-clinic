package amaciag.springframework.sfgpetclinic.services.map;

import amaciag.springframework.sfgpetclinic.model.BaseEntity;
import amaciag.springframework.sfgpetclinic.model.Owner;
import amaciag.springframework.sfgpetclinic.model.Pet;
import amaciag.springframework.sfgpetclinic.services.OwnerService;
import amaciag.springframework.sfgpetclinic.services.PetService;
import amaciag.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;

    private final PetService<BaseEntity, Number> petService;


    public OwnerServiceMap(PetTypeService petTypeService, PetService<BaseEntity, Number> petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        Owner savedOwner;
        if (object != null)
        {
            if (object.getPets() != null)
            {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null)
                    {
                        if (pet.getPetType().getId() == null)
                        {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else
                    {
                        throw new RuntimeException("Pet Type is requierd");
                    }

                    if (pet.getId() == null)
                    {

                        Pet savedPet = (Pet) petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }else
        {
            return  null;
        }


    }

    @Override
    public void delete(Owner object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {

        super.deleteById(id);

    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
