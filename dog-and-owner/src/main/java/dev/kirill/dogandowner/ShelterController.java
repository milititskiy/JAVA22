package dev.kirill.dogandowner;

import dev.kirill.dogandowner.respository.DogRepository;
import dev.kirill.dogandowner.respository.OwnerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@ResponseBody
@RestController
public class ShelterController {
    private final int idCounter = new AtomicInteger().getAndIncrement();
    private final OwnerRepository ownerRepo = new OwnerRepository();
    private final DogRepository dogRepo = new DogRepository();


    @PostMapping(
            value = "/owners",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        Owner createdOwner = ownerRepo.save(owner);
        createdOwner.setId(owner.getId());
        createdOwner.setFirstName(owner.getFirstName());
        createdOwner.setLastName(owner.getLastName());
        createdOwner.setBirthDate(owner.getBirthDate());
        createdOwner.setDogs(owner.getDogs());
        return new ResponseEntity<Owner>(createdOwner, HttpStatus.OK);
    }

    @GetMapping("owners/{id}")
    public ResponseEntity<Owner> getOwnersById(@PathVariable(value = "id") int id) {
        Owner existingOwner = ownerRepo.getOwnerById(id);
        return new ResponseEntity<Owner>(existingOwner, HttpStatus.OK);
    }

    @PostMapping(
            value = "/dogs",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Dog> createOwner(@RequestBody Dog dog) {
        Dog registeredDog = dogRepo.save(dog);
        registeredDog.setId(dog.getId());
        registeredDog.setNickname(dog.getNickname());
        registeredDog.setBreed(dog.getBreed());
        registeredDog.setDateOfBirth(dog.getDateOfBirth());
        registeredDog.setRegistrationDate(dog.getRegistrationDate());
        return new ResponseEntity<Dog>(registeredDog, HttpStatus.OK);
    }

    @GetMapping("dogs/unregistered")
    public ResponseEntity<ArrayList> getUnregDogs() {
        ArrayList<Dog> list = dogRepo.doglist;
        var unregisteredDogs = dogRepo.unregisterdDog(list);
        return new ResponseEntity<>(unregisteredDogs, HttpStatus.OK);
    }

    @PutMapping(
            value = "/owners/{id}/dogs/{dog_id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Owner> assignDogToOwner(
            @RequestBody Owner owner,
            @RequestBody Dog dog,
            @PathVariable(value = "id") int id,
            @PathVariable(value = "dog_id") int dog_id) {
        var registeredOwner = Objects.requireNonNull(ownerRepo.getOwnerById(id));
        var registeredDog = Objects.requireNonNull(dogRepo.getDogById(dog_id));
        registeredOwner.getDogs().add(registeredDog);
        Owner assignedWithDog = ownerRepo.save(registeredOwner);
        return new ResponseEntity<Owner>(assignedWithDog, HttpStatus.OK);
    }


}
