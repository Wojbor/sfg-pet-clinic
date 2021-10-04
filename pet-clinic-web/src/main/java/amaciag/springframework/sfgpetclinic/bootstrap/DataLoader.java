package amaciag.springframework.sfgpetclinic.bootstrap;

import amaciag.springframework.sfgpetclinic.model.Owner;
import amaciag.springframework.sfgpetclinic.model.Pet;
import amaciag.springframework.sfgpetclinic.model.PetType;
import amaciag.springframework.sfgpetclinic.model.Vet;
import amaciag.springframework.sfgpetclinic.services.OwnerService;
import amaciag.springframework.sfgpetclinic.services.PetTypeService;
import amaciag.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);
        //petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();

        owner1.setFisrtName("Arek");
        owner1.setLastName("Maciag");
        owner1.setAddress("Bata 123");
        owner1.setCity("Cracow");
        owner1.setTelephone("12312312");

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

        Pet janCat = new Pet();
        janCat.setName("Filek");
        janCat.setPetType(savedCatPetType);
        janCat.setOwner(owner2);
        janCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(janCat);

        ownerService.save(owner2);


        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();

        vet1.setFisrtName("Daniel");
        vet1.setLastName("Gryn");

        vetService.save(vet1);


        Vet vet2 = new Vet();

        vet2.setFisrtName("Max");
        vet2.setLastName("Sma");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");



    }
}
