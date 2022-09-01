package com.revature.controller;

import com.revature.entity.Employee;

import java.util.Scanner;

public class CommandLine {
    public static void menu() {
        System.out.println("Welcome to J.B.'s Reimbursement App!\n");
        System.out.println("Please choose from the following menu items");
        System.out.println("1 - Ticket Menu");
        System.out.println("2 - Employee menu");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> TicketCommandLineInterface.menu();
            case 2 -> EmployeeCommandLineInterface.menu();
            default -> System.out.println("Please choose 1 or 2");
        }


    }
}
