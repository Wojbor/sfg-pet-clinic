package amaciag.springframework.sfgpetclinic.services.map;

import amaciag.springframework.sfgpetclinic.model.Specialty;
import amaciag.springframework.sfgpetclinic.model.Vet;
import amaciag.springframework.sfgpetclinic.services.SpecialtyService;
import amaciag.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        if (object.getSpecialities().size() > 0)
        {
            object.getSpecialities().forEach(specialty -> {
                if (specialty.getId() == null)
                {
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }

        return super.save( object);
    }

    @Override
    public void delete(Vet object) {

        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {

        super.deleteById(id);

    }
}
