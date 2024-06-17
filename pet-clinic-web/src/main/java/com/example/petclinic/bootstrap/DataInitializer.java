package com.example.petclinic.bootstrap;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Vet;
import com.example.petclinic.service.map.OwnerServiceMap;
import com.example.petclinic.service.map.VetServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerServiceMap ownerServiceMap;
    private final VetServiceMap vetServiceMap;

    @Autowired
    public DataInitializer(OwnerServiceMap ownerServiceMap, VetServiceMap vetServiceMap) {
        this.ownerServiceMap = ownerServiceMap;
        this.vetServiceMap = vetServiceMap;
    }


    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("John");
        owner.setLastName("Doh");

        ownerServiceMap.save(owner);

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Paul");
        vet.setLastName("Smith");

        vetServiceMap.save(vet);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Fred");
        vet2.setLastName("Potter");

        vetServiceMap.save(vet2);

        System.out.println("Data loaded");
    }
}
