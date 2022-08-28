package dev.kirill.dogandowner.respository;

import dev.kirill.dogandowner.Dog;
import dev.kirill.dogandowner.Owner;

import java.util.ArrayList;
import java.util.Objects;

public class DogRepository {
    public ArrayList<Dog> doglist =  new ArrayList<>();

    public Dog save(Dog dog){
        doglist.add(dog);
        return dog;
    }

    public ArrayList<Dog> unregisterdDog(ArrayList<Dog> list){
         ArrayList<Dog> unregDogs = new ArrayList<>();
        for(Dog dog : list){
            if(dog.getRegistrationDate() == null){
                unregDogs.add(dog);
            }
        }
        return unregDogs;
    }

    public Dog getDogById(int id){
        Dog existingDog = null;
        for (Dog dog : doglist){
            if(dog.getId() == id){
                existingDog = dog;
            }
        }
        return existingDog;
    }
}
