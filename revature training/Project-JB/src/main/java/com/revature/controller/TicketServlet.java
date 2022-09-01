package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.entity.Ticket;
import com.revature.service.TicketService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TicketServlet extends HttpServlet{
    // type out doGet, and you should get a shortcut for the get method:
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        System.out.println(user);

        // get information about the path:
        String pathInfo = req.getPathInfo();
        System.out.println("Path info: " + pathInfo); // path info will be null, if we don't have any extra values

        // create an instance of the pet service, so we can use those methods:
        TicketService ticketService = new TicketService();
        // set up print writer
        PrintWriter out = resp.getWriter();


        // if our path info is null, it means we didn't specify an id
        // which means that we return every single ticket:
        if (pathInfo == null) {
            List<Ticket> tickets = ticketService.getAllTickets();
            for(Ticket ticket: tickets) {
                out.println(ticket);
            }
        }
        else {
            // parse the id from the path:
            // take every character starting from 1 to the end of the string
            // /345 -> 345
            String id = pathInfo.substring(1);
            // take the string and convert it to an integer:
            int idInteger = Integer.parseInt(id);
            Ticket ticket = ticketService.getById(idInteger);
            out.println(ticket);
        }

    }

    // localhost:8080/pets?user=rory&password=123
    // the safer way to do this is adding information to the body


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        TicketService ticketService = new TicketService();
        // the object mapper will convert JSON (the body of the request) to Java entity (Ticket class)
        ObjectMapper mapper = new ObjectMapper();

        // we need a way to take the JSON body and convert it to a Java object:
        Ticket ticket;

        // do some error handling to check for bad requests/invalid data:
        // passing in the request reader and the designated class:
        try {
            ticket = mapper.readValue(req.getReader(), Ticket.class);

        } catch (Exception e) {
            e.printStackTrace();
            // 400 means bad request, and we provide a description of the error that came up:
            resp.sendError(400, "Invalid ticket format");
            // return from the method
            return;
        }

        // ticket should have id after it's inserted:
        ticket = ticketService.insert(ticket);
        out.println(ticket);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        TicketService petService = new TicketService();
        // the object mapper will convert JSON (the body of the request) to Java entity (Pet class)
        ObjectMapper mapper = new ObjectMapper();

        // we need a way to take the JSON body and convert it to a Java object:
        Ticket ticket;

        // do some error handling to check for bad requests/invalid data:
        // passing in the request reader and the designated class:
        try {
            ticket = mapper.readValue(req.getReader(), Ticket.class);
        } catch (Exception e) {
            e.printStackTrace();
            // 400 means bad request, and we provide a description of the error that came up:
            resp.sendError(400, "Invalid pet format");
            // return from the method
            return;
        }

        // instead of inserting an entirely new pet, we are going to update it
        TicketService ticketService = new TicketService();
        ticket = ticketService.updateStatus(ticket);
        out.println(ticket);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TicketService petService = new TicketService();
        PrintWriter out = resp.getWriter();

        String pathInfo = req.getPathInfo();
        if(pathInfo == null) {
            resp.sendError(400, "Must include id");
            return;
        }

        String id = pathInfo.substring(1);
        int idInteger = Integer.parseInt(id);

        boolean success = petService.deleteTicket(idInteger);
        if(success) {
            out.write("Deletion successful!");
        }
        else {
            resp.sendError(400, "Deletion unsuccessful, perhaps id doesn't exist?");
        }
    }
}
