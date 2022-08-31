package com.revature.service;

import com.revature.data.DaoFactory;
import com.revature.data.PersonDao;
import com.revature.data.PetDao;
import com.revature.entity.Person;
import com.revature.entity.Pet;

import java.util.ArrayList;
import java.util.List;

// Service classes contain business logic of what's going on:
public class PersonService {

    // we take in a Person object with just name and password
    public Person register(Person person) {
        // we want to send back data from database
        // inserting this new person into the database:
        PersonDao personDao = DaoFactory.getPersonDao();
        Person person1 = personDao.insert(person);
        return person1;
    }

    // return a person object if the id and password match what's in the database
    // otherwise, we can return null:
    public Person login(int id, String password) {
        // business logic where we check the password:
        // first let's get the person from the database:
        PersonDao personDao = DaoFactory.getPersonDao();
        Person person = personDao.getById(id);
        if (password.equals(person.getPassword())) {
            // if they match, we return the person
            return person;
        }
        // if passwords don't match, return null, indicating that the password is incorrect
        return null;
    }

    // Given a person id and a pet id, have that person adopt that pet:
    public boolean adopt(int personId, int petId) {
        // we actually have to interact with the pet database
        PetDao petDao = DaoFactory.getPetDao();
        // return boolean indicates whether or not the adoption was successful
        return petDao.adopt(personId, petId);
    }

    // given a person's id, return all pets that were adopted by them
    public List<Pet> getAdoptedPets(int personId) {
        PetDao petDao = DaoFactory.getPetDao();
        return petDao.getAdoptedPets(personId);
    }

}
