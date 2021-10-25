package amaciag.springframework.sfgpetclinic.services.springdatajpa;

import amaciag.springframework.sfgpetclinic.model.Owner;
import amaciag.springframework.sfgpetclinic.repositories.OwnerRepository;
import amaciag.springframework.sfgpetclinic.repositories.PetRepository;
import amaciag.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String MAC = "Mac";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner ownerReturned;

    @BeforeEach
    void setUp() {
        ownerReturned = Owner.builder().fisrtName("Jhon").build();

    }

    @Test
    void findByLastName() {
        Owner owner = Owner.builder().lastName(MAC).build();

        when(ownerRepository.findByLastName(any())).thenReturn(owner);

        Owner smith = service.findByLastName(MAC);

        assertEquals(MAC, smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        Owner owner = Owner.builder().fisrtName("Jhon").build();
        Owner owner2 = Owner.builder().fisrtName("Jhon").build();

        owners.add(owner);
        owners.add(owner2);

        when(ownerRepository.findAll()).thenReturn(owners);


        owners = service.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());

    }

    @Test
    void findById() {


        when(ownerRepository.findById(1l)).thenReturn(Optional.of(ownerReturned));

        Owner owner = service.findById(1L);

        assertNotNull(owner);




    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().fisrtName("Karen").build();

        when(service.save(any())).thenReturn(ownerReturned);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);
    }

    @Test
    void delete() {

        service.delete(ownerReturned);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1l);

        verify(ownerRepository,times(1)).deleteById(anyLong());
    }

}