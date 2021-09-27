package amaciag.springframework.sfgpetclinic.bootstrap;

import amaciag.springframework.sfgpetclinic.model.Owner;
import amaciag.springframework.sfgpetclinic.model.Vet;
import amaciag.springframework.sfgpetclinic.services.OwnerService;
import amaciag.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }



    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();

        owner1.setFisrtName("Arek");
        owner1.setLastName("Maciag");

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFisrtName("Jan");
        owner2.setLastName("Kowalski");

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
