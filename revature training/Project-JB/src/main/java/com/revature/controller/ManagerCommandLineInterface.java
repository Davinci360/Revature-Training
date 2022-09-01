package com.revature.controller;

import com.revature.entity.Employee;
import com.revature.entity.Ticket;
import com.revature.service.EmployeeService;
import com.revature.service.TicketService;

import java.util.Scanner;

public class ManagerCommandLineInterface extends TicketCommandLineInterface {
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

                case 3: //UPDATE TICKET@TODO Reslove Errors to create a Update Ticket Status Case
                    System.out.println("Enter ticket information");
                    System.out.print("Ticket Id => ");
                    id = intScanner.nextInt();
                    System.out.print("Ticket Amount => ");
                    double amount = intScanner.nextDouble();
                    System.out.print("Ticket Description => ");
                    String description = stringScanner.nextLine();
                    System.out.print("Ticket Status => ");
                    String status = stringScanner.nextLine();
                    System.out.print("Ticket User_id => ");
                    int user_id = intScanner.nextInt();
                    Ticket ticket = new Ticket(id, amount, description, status, user_id);
                    System.out.println(ticketService.updateTicket(ticket));
                    break;



            }

        }
    }

    public static void printOptions() {
        System.out.println("What would you like to do?");
        System.out.println("1 - Register");
        System.out.println("2 - Login");
        System.out.println("3 - Process Tickets");

        System.out.print("Enter => ");
    }
}
