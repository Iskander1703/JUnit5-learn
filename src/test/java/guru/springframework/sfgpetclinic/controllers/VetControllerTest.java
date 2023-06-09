package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.controllers.models.VetModel;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.interfaces.ControllerTests;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import guru.springframework.sfgpetclinic.services.springdatajpa.VetSDJpaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest implements ControllerTests {

    private VetController vetController;

    private VetService vetService;

    private SpecialtyService specialtyService;

    @BeforeEach
    void setUp() {
        SpecialtyService specialtyService = new SpecialityMapService();
        VetService vetService = new VetMapService(specialtyService);
        vetController = new VetController(vetService);

        Vet vet1=new Vet(1l,"Iskander","Tabaev", null);
        Vet vet2=new Vet(2l,"Roman","Stepanov", null);

        vetService.save(vet1);
        vetService.save(vet2);

    }

    @Test
    void listVets() {
        Model model = new VetModel();
        assertEquals("vets/index", vetController.listVets(model));
        assertThat("vets/index").isEqualTo(vetController.listVets(model));
        
        Set modelAttribute = (Set) ((VetModel) model).getModelHashMap().get("vets");
        assertThat(modelAttribute.size()).isEqualTo(2);

    }
}