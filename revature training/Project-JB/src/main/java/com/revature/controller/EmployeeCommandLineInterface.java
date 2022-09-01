package com.revature.controller;

import com.revature.entity.Employee;
import com.revature.entity.Ticket;
import com.revature.service.EmployeeService;
import com.revature.service.TicketService;

import java.util.List;
import java.util.Scanner;

public class EmployeeCommandLineInterface {
    public static void menu() {
        EmployeeService employeeService = new EmployeeService();
        TicketService ticketService = new TicketService();

        // this will store the current logged-in user
        Employee employee = null;

        // set up scanners
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
//----------------MENU BLOCK-----------------------------------
        while(true) { //continuously checks for user input
            printOptions(); //brings up initial menu
            int choice = intScanner.nextInt(); // takes in users menu choice (int)
            switch(choice) {
                case 1:
                    if(employee != null) { //makes sure you cant login twice
                        System.out.println("User is already logged in.");
                        break;
                    }
                    //--------LOGIN PROCESS-----------
                    // Take in name and password
                    System.out.print("Name => ");
                    String name = stringScanner.nextLine();

                    System.out.print("Password => ");
                    String password = stringScanner.nextLine();

                    Employee employee1 = new Employee(name, password);
                    // if the registration is successful, then this will be a non-null object
                    employee = employeeService.register(employee1);
                    break;

                case 2:
                    if(employee != null) { // employee  should be null when not logged in
                        System.out.println("You are already logged in.");
                        break;
                    }
                    System.out.print("Enter id => ");
                    int id = intScanner.nextInt();//intakes user input id
                    System.out.print("Enter password => ");
                    password = stringScanner.nextLine();//intakes user input password
                    employee = employeeService.login(id, password);
                    if(employee == null) { //blocks double login throws mssg
                        System.out.println("Login unsuccessful!");
                    }
                    break;

                case 3:
                    if (employee == null) {
                        System.out.println("You must be logged in to claim a ticket!");
                        break;
                    }

                    System.out.println("Available tickets:");
                    for(Ticket ticket : ticketService.getAllTickets()) {
                        System.out.println(ticket.toString());
                    }

                    // if we've made it here, that means we are logged in and have an id:
                    System.out.print("Enter the id of the ticket you would like to claim:");
                    int ticketId = intScanner.nextInt();
                    boolean success = employeeService.claim(employee.getId(), ticketId);
                    if (success) {
                        System.out.println("Claim successful!");
                    }
                    else {
                        System.out.println("Something went wrong with the claim.");
                    }
                    break;
                case 4:
                    if (employee == null) {
                        System.out.println("Please log in first");
                        break;
                    }


                    List<Ticket> tickets = employeeService.getClaimedTickets(employee.getId());

                    System.out.println("Here are your claimed tickets:");
                    for(Ticket ticket : tickets) {
                        System.out.println(ticket);
                    }

                    break;
//-----------NEW TICKET-------------------------
                case 5:
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
            }

        }
    }

    public static void printOptions() {
        System.out.println("What would you like to do?");
        System.out.println("1 - Register");
        System.out.println("2 - Login");
        System.out.println("3 - Claim");
        System.out.println("4 - View My Tickets");
        System.out.println("5 - Create Ticket");
        System.out.print("Enter => ");
    }
}
