package dev.kirill.dogandowner.respository;

import dev.kirill.dogandowner.Owner;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OwnerRepository {
    public ArrayList<Owner> ownerList = new ArrayList<>();

    public OwnerRepository(){
    }

    public Owner save(Owner owner) {
        ownerList.add(owner);
        return owner;
    }

    public Owner getOwnerById(int id){
        Owner existingOwner = null;
        for (Owner owner : ownerList){
            if(owner.getId() == id){
                existingOwner = owner;
            }
        }
        return existingOwner;
    }

}
