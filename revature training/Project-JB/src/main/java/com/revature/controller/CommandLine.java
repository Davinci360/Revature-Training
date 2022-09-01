package com.revature.controller;

import com.revature.entity.Employee;

import java.util.Scanner;

public class CommandLine {
    public static void menu() {
        System.out.println("************************************");
        System.out.println("Welcome to J.B.'s Reimbursement App!");
        System.out.println("************************************");

        System.out.println("Please choose from the following menu items");
        System.out.println("1 - Ticket Menu");
        System.out.println("2 - Employee menu");
        System.out.println("3 - Manager menu");

        System.out.print("Enter Choice => ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> TicketCommandLineInterface.menu();
            case 2 -> EmployeeCommandLineInterface.menu();
            case 3 -> ManagerCommandLineInterface.menu();

            default -> System.out.println("Please choose 1 or 2");
        }


    }
}
