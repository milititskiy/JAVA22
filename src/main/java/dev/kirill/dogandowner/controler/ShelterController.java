package dev.kirill.dogandowner.controler;

import dev.kirill.dogandowner.entity.Dog;
import dev.kirill.dogandowner.entity.Owner;
import dev.kirill.dogandowner.respository.DogRepository;
import dev.kirill.dogandowner.respository.OwnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class ShelterController {


    private final OwnerRepository ownerRepository;
    private final DogRepository dogRepository;

    // Powered by Spring Engine
//    @Autowired

    // Powered by Lombok
//    public ShelterController(OwnerRepository ownerRepository, DogRepository dogRepository) {
//        this.ownerRepository = ownerRepository;
//        this.dogRepository = dogRepository;
//    }

    @PostMapping(value = "/owners")
    public Owner createOwner(@RequestBody Owner owner) {
        return null;
    }

    @GetMapping("owners/{id}")
    public Owner getOwnersById(@PathVariable(value = "id") Long id) {
        return null;
    }

    @PostMapping(value = "/dogs")
    public Dog createOwner(@RequestBody Dog dog) {
        return dog;
    }

    @GetMapping("dogs/unregistered")
    public List<Dog> getUnregisteredDogs() {
        return null;
    }

    @PutMapping(value = "/owners/{ownerId}/dogs/{dogId}")
    public Owner assignDogToOwner(
            @PathVariable(value = "ownerId") Long ownerId,
            @PathVariable(value = "dogId") Long dogId) {

        return null;
    }


}
