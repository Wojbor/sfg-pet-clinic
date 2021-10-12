package amaciag.springframework.sfgpetclinic.bootstrap;

import amaciag.springframework.sfgpetclinic.model.*;
import amaciag.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtiesService;
    private final VisitService visitService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0)
        {
            loadData();

        }



    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);
        //petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtiesService.save(radiology);


        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtiesService.save(surgery);


        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtiesService.save(dentistry);


        Owner owner1 = new Owner();

        owner1.setFisrtName("Arek");
        owner1.setLastName("Maciag");
        owner1.setAddress("Bata 123");
        owner1.setCity("Cracow");
        owner1.setTelephone("12312312");


        Owner.builder().fisrtName("asd").lastName("asd").build();

        Pet areksDog = new Pet();
        areksDog.setName("Burek");
        areksDog.setPetType(savedDogPetType);
        areksDog.setOwner(owner1);
        areksDog.setBirthDate(LocalDate.now());
        owner1.getPets().add(areksDog);

        ownerService.save(owner1);


        Owner owner2 = new Owner();

        owner2.setFisrtName("Jan");
        owner2.setLastName("Kowalski");
        owner2.setAddress("Bata 124");
        owner2.setCity("Cracow");
        owner2.setTelephone("1231");

        Owner owner3 = new Owner();

        owner3.setFisrtName("Beata");
        owner3.setLastName("Kryp");
        owner3.setAddress("Szczen 12");
        owner3.setCity("Cracow");
        owner3.setTelephone("12 009");

        ownerService.save(owner3);



        Pet janCat = new Pet();
        janCat.setName("Filek");
        janCat.setPetType(savedCatPetType);
        janCat.setOwner(owner2);
        janCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(janCat);

        ownerService.save(owner2);

        Visit visit = new Visit();
        visit.setPet(janCat);
        visit.setDate(LocalDate.now());
        visit.setDescription("Cat Snezze");


        visitService.save(visit);

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();

        vet1.setFisrtName("Daniel");
        vet1.setLastName("Gryn");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);


        Vet vet2 = new Vet();

        vet2.setFisrtName("Max");
        vet2.setLastName("Sma");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
