package com.revature;

import com.revature.controller.CommandLine;

// Main class, this is the starting point of the project
// This class should be pretty bare-bones. We'll basically just be setting up our controller
public class App {
    public static void main(String[] args) {
        // call the menu method that we set up in our command line interface:
        CommandLine.menu();
    }
}
