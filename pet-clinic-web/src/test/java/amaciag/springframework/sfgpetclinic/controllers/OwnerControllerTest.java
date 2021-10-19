package amaciag.springframework.sfgpetclinic.controllers;

import amaciag.springframework.sfgpetclinic.model.Owner;
import amaciag.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OwnerControllerTest {

    OwnerController ownerController;

    @Mock
    OwnerService ownerService;

    @Mock
    Model model;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        ownerController = new OwnerController(ownerService);

    }

    @Test
    void listOwners() {
        ArgumentCaptor<Set<Owner>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
        Set<Owner> owners = new HashSet<>();

        Owner owner = Owner.builder().fisrtName("Arel").lastName("Mac").build();

        owners.add(owner);

        when(ownerService.findAll()).thenReturn(owners);

        String exitVauleListOwner = ownerController.listOwners(model);

        assertEquals("owners/index", exitVauleListOwner);
        verify(ownerService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("owners"), argumentCaptor.capture());
        Set<Owner> dataInOwnerController  = argumentCaptor.getValue();
        assertEquals(1, owners.size());
    }

    @Test
    @Disabled
    void findOwners() {
    }
}