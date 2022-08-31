package com.revature.data;

import com.revature.entity.Pet;

import java.util.ArrayList;
import java.util.List;

// this is a temporary implementation of the Pet Dao before we get our database set up
// A lot of these methods are going to give out dummy data
// ctrl-i to generate implemented methods
public class PetDaoTempImpl implements PetDao {

    @Override
    public Pet insert(Pet pet) {
        // print out a dummy message
        System.out.println("Inserting pet: " + pet.toString());
        // arbitrarily set the id and return the pet
        pet.setId(2);
        return pet;
    }

    @Override
    public Pet getById(int id) {
        Pet dummyPet = new Pet(id, "Pet from Database", "cat", "meow mix");
        return dummyPet;
    }

    @Override
    public List<Pet> getAllPets() {
        Pet pet1 = new Pet(1, "Ashes", "cat", "tuna juice");
        Pet pet2 = new Pet(2, "Shadow", "cat", "water");
        // In Java, list is an interface, so we can't instantiate it
        // because ArrayList implements List, we can do this:
        List<Pet> pets = new ArrayList<>();
        pets.add(pet1);
        pets.add(pet2);
        return pets;
    }

    @Override
    public Pet update(Pet pet) {
        // say we pass in
        /*
        id: 1
        name: new name
        species: new species
        food: new good
         */
        // in the "real" implementation, we will update the database:
        System.out.println("Updated pet: " + pet.toString());
        return pet;
    }

    @Override
    public boolean delete(int id) {
        System.out.println("Delete pet with id: " + id);
        return true;
    }

    @Override
    public boolean adopt(int personId, int petId) {
        return false;
    }

    @Override
    public List<Pet> getAdoptedPets(int personId) {
        return null;
    }
}
