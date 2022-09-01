package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.entity.Employee;
import com.revature.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EmployeeServlet extends HttpServlet{
    // type out doGet, and you should get a shortcut for the get method:
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // create an instance of the employee service, so we can use those methods:
        EmployeeService employeeService = new EmployeeService();
        // set up print writer
        PrintWriter out = resp.getWriter();
        int employeeid;
        try {
            employeeid = (Integer)req.getSession().getAttribute("id");

        } catch (Exception e) {
            e.printStackTrace();
            // 400 means bad request, and we provide a description of the error that came up:
            resp.sendError(401, "must be logged in to do that");
            // return from the method
            return;
        } List<Employee> employees = employeeService.getAllUsers(employeeid);
        for (Employee employee: employees){
            out.println(employee);
        }
    }

    // localhost:8080/pets?user=rory&password=123
    // the safer way to do this is adding information to the body


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        EmployeeService employeeService = new EmployeeService();
        // the object mapper will convert JSON (the body of the request) to Java entity (Ticket class)
        ObjectMapper mapper = new ObjectMapper();

        // we need a way to take the JSON body and convert it to a Java object:
        Employee employee;

        // do some error handling to check for bad requests/invalid data:
        // passing in the request reader and the designated class:
        try {
            employee = mapper.readValue(req.getReader(), Employee.class);

        } catch (Exception e) {
            e.printStackTrace();
            // 400 means bad request, and we provide a description of the error that came up:
            resp.sendError(400, "Invalid employee format");
            // return from the method
            return;
        }
        String authType = req.getParameter("auth");
        if (authType.equals("login")){
            employee = employeeService.login(employee.getId(), employee.getPassword());

        } else if (authType.equals("register")) {
            employee = employeeService.register(employee);

        }
        if (employee == null) {
            resp.sendError(400,"Invalid Login");
            return;
        } out.println(employee.getName());
        req.getSession().setAttribute("id",employee.getId());

        // ticket should have id after it's inserted:

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        EmployeeService employeeService = new EmployeeService();
        // the object mapper will convert JSON (the body of the request) to Java entity (Pet class)
        ObjectMapper mapper = new ObjectMapper();

        // we need a way to take the JSON body and convert it to a Java object:
        Employee employee;

        // do some error handling to check for bad requests/invalid data:
        // passing in the request reader and the designated class:
        try {
            employee = mapper.readValue(req.getReader(), Employee.class);
        } catch (Exception e) {
            e.printStackTrace();
            // 400 means bad request, and we provide a description of the error that came up:
            resp.sendError(400, "Invalid pet format");
            // return from the method
            return;
        }

        employee = employeeService.update(employee);
        out.println(employee);
    }

/*    @Override
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
    }*/
}
