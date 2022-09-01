package com.revature.controller;

import com.revature.entity.Ticket;
import com.revature.service.TicketService;

import java.util.List;
import java.util.Scanner;

// A very primitive controller, where we accept requests from the command line and direct to the appropriate service
public class TicketCommandLineInterface {
    public static void menu() {
        // initialize our Ticket Service:
        TicketService ticketService = new TicketService();
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
                //----------NEW TICKET---------------------
                case 1:
                    System.out.println("Enter ticket information");
                    System.out.print("Ticket Amount => ");
                    double amount = intScanner.nextDouble();
                    System.out.print("Ticket Description => ");
                    String description = stringScanner.nextLine();
                    System.out.print("Ticket Status => ");
                    String status = stringScanner.nextLine();
                    System.out.print("Ticket User_id => ");
                    int user_id = intScanner.nextInt();

                    Ticket newTicket = new Ticket(amount, description, status, user_id);
                    System.out.println(ticketService.insert(newTicket));
                    break;
                case 2:
                    System.out.print("Enter a User id: ");
                    int id = intScanner.nextInt();
                    System.out.println(ticketService.getById(id));
                    break;
                case 3:
                    List<Ticket> tickets = ticketService.getAllTickets();
                    for (Ticket value : tickets) {
                        System.out.println(value);
                    }
                    break;
                case 4: //UPDATE TICKET
                    System.out.println("Enter ticket information");
                    System.out.print("Ticket Id => ");
                    id = intScanner.nextInt();
                    System.out.print("Ticket Amount => ");
                    amount = intScanner.nextDouble();
                    System.out.print("Ticket Description => ");
                    description = stringScanner.nextLine();
                    System.out.print("Ticket Status => ");
                    status = stringScanner.nextLine();
                    System.out.print("Ticket User_id => ");
                    user_id = intScanner.nextInt();
                    Ticket ticket = new Ticket(id, amount, description, status, user_id);
                    System.out.println(ticketService.updateStatus(ticket));
                    break;
/*                case 5:
                    System.out.println("Enter in id to delete");
                    System.out.print("Id => ");
                    id = intScanner.nextInt();
                    if(ticketService.deleteTicket(id)) {
                        System.out.println("Ticket successfully deleted");
                    }
                    else {
                        System.out.println("Something went wrong when deleting the ticket");
                    }
                    break;*/
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
        System.out.println("1 - Add ticket");
        System.out.println("2 - Get ticket by id");
        System.out.println("3 - Get all tickets");
        System.out.println("4 - Update ticket");// TODO set access for MANAGERS ONLY and only return PENDING tickets,
      //  System.out.println("5 - Delete ticket");
        System.out.print("Enter Choice => ");
    }
}
