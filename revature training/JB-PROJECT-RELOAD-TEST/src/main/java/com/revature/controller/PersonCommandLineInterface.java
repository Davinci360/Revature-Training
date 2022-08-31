package com.revature.controller;

import com.revature.entity.Person;
import com.revature.entity.Pet;
import com.revature.service.PersonService;
import com.revature.service.PetService;

import java.util.List;
import java.util.Scanner;

public class PersonCommandLineInterface {
    public static void menu() {
        PersonService personService = new PersonService();
        PetService petService = new PetService();

        // this will store the current logged in user
        Person person = null;

        // set up scanners
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);

        while(true) {
            printOptions();
            int choice = intScanner.nextInt();
            switch(choice) {
                case 1:
                    if(person != null) {
                        System.out.println("You are already logged in.");
                        break;
                    }
                    // Take in name and password
                    System.out.print("Name => ");
                    String name = stringScanner.nextLine();
                    System.out.print("Password => ");
                    String password = stringScanner.nextLine();
                    Person person1 = new Person(name, password);
                    // if the registration is successful, then this will be a non-null object
                    person = personService.register(person1);
                    break;
                case 2:
                    if(person != null) {
                        System.out.println("You are already logged in.");
                        break;
                    }
                    System.out.print("Enter id => ");
                    int id = intScanner.nextInt();
                    System.out.print("Enter password => ");
                    password = stringScanner.nextLine();
                    person = personService.login(id, password);
                    if(person == null) {
                        System.out.println("Login unsuccessful!");
                    }
                    break;
                case 3:
                    if (person == null) {
                        System.out.println("You must be logged in to adopt a pet!");
                        break;
                    }
                    System.out.println("Available pets:");
                    for(Pet pet: petService.getAllPets()) {
                        System.out.println(pet.toString());
                    }
                    // if we've made it here, that means we are logged in and have an id:
                    System.out.print("Enter the id of the pet you would like to adopt:");
                    int petId = intScanner.nextInt();
                    boolean success = personService.adopt(person.getId(), petId);
                    if (success) {
                        System.out.println("Adoption successful!");
                    }
                    else {
                        System.out.println("Something went wrong with the adoption.");
                    }
                    break;
                case 4:
                    if (person == null) {
                        System.out.println("Please log in first");
                        break;
                    }
                    List<Pet> pets = personService.getAdoptedPets(person.getId());

                    System.out.println("Here are your adopted pets:");
                    for(Pet pet: pets) {
                        System.out.println(pet);
                    }

                    break;
            }

        }
    }

    public static void printOptions() {
        System.out.println("What would you like to do?");
        System.out.println("1 - Register");
        System.out.println("2 - Login");
        System.out.println("3 - Adopt");
        System.out.println("4 - View My Pets");
        System.out.print("Enter => ");
    }
}
