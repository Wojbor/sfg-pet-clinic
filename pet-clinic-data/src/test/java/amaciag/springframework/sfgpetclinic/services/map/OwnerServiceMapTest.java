package amaciag.springframework.sfgpetclinic.services.map;

import amaciag.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final String lastName = "Mac";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

        ownerServiceMap.save(Owner.builder().fisrtName("arek").lastName("Mac").build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();

        assertEquals(1, owners.size());



    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(1L);
        System.out.println(owner.getId());

        assertEquals(1, owner.getId());
    }

    @Test
    void saveOwner() {
        Owner owner2 = Owner.builder().fisrtName("Jhon").build();

        Owner savedOwner =  ownerServiceMap.save(owner2);

        assertEquals("Jhon", savedOwner.getFisrtName());
    }

    @Test
    void deleteOwner() {
        ownerServiceMap.delete(ownerServiceMap.findById(1l));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {

        ownerServiceMap.deleteById(1l);

        assertEquals(null, ownerServiceMap.findById(1l));


    }

    @Test
    void findByLastName() {

        Owner owner = ownerServiceMap.findByLastName(lastName);

        assertNotNull(owner);

        assertEquals(lastName, owner.getLastName());
    }

    @Test
    void findByLastNameNotFound() {

        Owner owner = ownerServiceMap.findByLastName("NotFound");

        assertNull(owner);
    }
}