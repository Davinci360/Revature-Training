package com.revature.service;

import com.revature.data.DaoFactory;
import com.revature.data.EmployeeDao;
import com.revature.data.TicketDao;
import com.revature.entity.Employee;
import com.revature.entity.Ticket;

import java.util.List;

// Service classes contain business logic of what's going on:
public class EmployeeService {

    // we take in an Employee object with just name and password
    public Employee register(Employee person) {
        // we want to send back data from database
        // inserting this new person into the database:
        EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
        Employee employee1 = employeeDao.insert(person);
        return employee1;
    }

    // return a person object if the id and password match what's in the database
    // otherwise, we can return null:
    public Employee login(int id, String password) {
        // business logic where we check the password:
        // first let's get the person from the database:
        EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
        Employee employee = employeeDao.getById(id);
        if (password.equals(employee.getPassword())) {
            // if they match, we return the person
            return employee;
        }
        // if passwords don't match, return null, indicating that the password is incorrect
        return null;
    }
    public List<Employee> getAllUsers(int userID){
        EmployeeDao userDao = DaoFactory.getEmployeeDao();
        return userDao.getAllUsers();
    }



    // given an employee's id, return all tickets that were claimed by them
    public boolean claim(int employeeId, int ticketId) {
        // we actually have to interact with the ticket database
        TicketDao ticketDao = DaoFactory.getTicketDao();
        // return boolean indicates whether the adoption was successful
        return ticketDao.claim(employeeId, ticketId);
    }

    // given an employee's id, return all tickets that were claimed by them
    public List<Ticket> getClaimedTickets(int employeeId) {
        TicketDao ticketDao = DaoFactory.getTicketDao();
        return ticketDao.getClaimedTickets(employeeId);
    }

    public Employee update(Employee employee) {
        EmployeeDao userDao = DaoFactory.getEmployeeDao();
            return userDao.update(employee);

    }
}
