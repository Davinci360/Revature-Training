package com.revature.service;

import com.revature.data.DaoFactory;
import com.revature.data.TicketDao;
import com.revature.entity.Ticket;

import java.util.List;

// for this class, a lot of our methods
// are going to be a matter of creating a dao and then calling the method:
public class TicketService {
    public Ticket insert(Ticket ticket) {
        System.out.println("In the service layer, getting the DAO and calling the insert DAO method");
        // declare a ticket dao and give it the temporary implementation that we have:
        TicketDao ticketDao = DaoFactory.getTicketDao();
        // insert the ticket and return the return value:
        return ticketDao.insert(ticket);
    }

    public Ticket getById(int id) {
        TicketDao ticketDao = DaoFactory.getTicketDao();
        return ticketDao.getById(id);
    }

    public List<Ticket> getAllTickets() {
        TicketDao ticketDao = DaoFactory.getTicketDao();
        return ticketDao.getAllTickets();
    }

    public Ticket updateTicket(Ticket ticket) {
        TicketDao ticketDao = DaoFactory.getTicketDao();
        return ticketDao.update(ticket);
    }

    public boolean deleteTicket(int id) { // WHY is this Boolean? It's FALSE if the ticket doesn't exist
        TicketDao ticketDao = DaoFactory.getTicketDao();
        return ticketDao.delete(id);
    }



}
