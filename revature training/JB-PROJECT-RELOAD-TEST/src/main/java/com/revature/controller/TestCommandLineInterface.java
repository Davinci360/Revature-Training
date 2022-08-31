package com.revature.controller;

import com.revature.entity.Pet;
import com.revature.service.PetService;

import java.util.List;
import java.util.Scanner;

// A very primitive controller, where we accept requests from the command line and direct to the appropriate service
public class TestCommandLineInterface {
    public static void menu() {
        // initialize our Pet Service:
        PetService petService = new PetService();
        // set up scanners
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        // loop endlessly
        while(true) {
            // print out the options:
            printOptions();
            // get the choice from the user:
            int choice = intScanner.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter pet information");
                    System.out.print("Pet Name => ");
                    String name = stringScanner.nextLine();
                    System.out.print("Pet Species => ");
                    String species = stringScanner.nextLine();
                    System.out.print("Pet Food => ");
                    String food = stringScanner.nextLine();
                    Pet newPet = new Pet(name, species, food);
                    System.out.println(petService.insert(newPet));
                    break;
                case 2:
                    System.out.print("Enter in an id: ");
                    int id = intScanner.nextInt();
                    System.out.println(petService.getById(id));
                    break;
                case 3:
                    List<Pet> pets = petService.getAllPets();
                    for(int i = 0; i < pets.size(); i ++) {
                        System.out.println(pets.get(i));
                    }
                    break;
                case 4:
                    System.out.println("Enter pet information");
                    System.out.print("Pet Id => ");
                    id = intScanner.nextInt();
                    System.out.print("Pet Name => ");
                    name = stringScanner.nextLine();
                    System.out.print("Pet Species => ");
                    species = stringScanner.nextLine();
                    System.out.print("Pet Food => ");
                    food = stringScanner.nextLine();
                    Pet pet = new Pet(id, name, species, food);
                    System.out.println(petService.updatePet(pet));
                    break;
                case 5:
                    System.out.println("Enter in id to delete");
                    System.out.print("Id => ");
                    id = intScanner.nextInt();
                    if(petService.deletePet(id)) {
                        System.out.println("Pet successfully deleted");
                    }
                    else {
                        System.out.println("Something went wrong when deleting the pet");
                    }
                    break;
                // in the case of just updating food:
//                case 6:
//                    System.out.println("Enter id=>");
//                    System.out.println("Enter food =>");
                default:
                    System.out.println("Not a valid option.");
                    break;
            }



        }
    }

    public static void printOptions() {
        System.out.println("What would you like to do?");
        System.out.println("1 - Add pet");
        System.out.println("2 - Get pet by id");
        System.out.println("3 - Get all pets");
        System.out.println("4 - Update pet");
        System.out.println("5 - Delete pet");
        System.out.print("Enter => ");
    }
}
