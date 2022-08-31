package com.revature.data;


import com.revature.entity.Pet;

import java.util.List;

// DAO - data access object
// We can have a Dao that is specific to the pet entity
public interface PetDao {
    // CRUD
    // Create - inserting a pet into the database
    // the reason we return the pet is so we can keep track of the id:
    public Pet insert(Pet pet);

    // Read - getting/reading data from the database
    // we pass in the id because they are unique
    public Pet getById(int id);
    // getting all pets takes no parameters because we're not specifying anything
    public List<Pet> getAllPets();

    // Update - update some data that is already in the database
    // take an id to identify what pet we're updating
    // and some pet data which is the new information that we are persisting
    public Pet update(Pet pet);

    // Delete - delete an item from the database:
    // return whether the deletion was successful
    // pass in an id to identify which pet is going to be deleted
    public boolean delete(int id);

    public boolean adopt(int personId, int petId);

    public List<Pet> getAdoptedPets(int personId);
}
