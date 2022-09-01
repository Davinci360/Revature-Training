package com.revature.data;


import com.revature.entity.Ticket;

import java.util.List;

// DAO - data access object
// We can have a Dao that is specific to the ticket entity
public interface TicketDao {
    // CRUD
    // Create - inserting a ticket into the database
    // the reason we return the ticket is so we can keep track of the id:
    public Ticket insert(Ticket ticket);

    // Read - getting/reading data from the database
    // we pass in the id because they are unique
    public Ticket getById(int id);
    // getting all pets takes no parameters because we're not specifying anything
    public List<Ticket> getAllTickets();

    // Update - update some data that is already in the database
    // take an id to identify what ticket we're updating
    // and some ticket data which is the new information that we are persisting
    public Ticket update(Ticket ticket);

    // Delete - delete an item from the database:
    // return whether the deletion was successful
    // pass in an id to identify which ticket is going to be deleted
    public boolean delete(int id);

    public boolean claim(int employeeId, int ticketId);

    public List<Ticket> getClaimedTickets(int employeeId);
}
