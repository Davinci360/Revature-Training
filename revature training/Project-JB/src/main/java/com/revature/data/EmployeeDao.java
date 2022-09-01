package com.revature.data;

import com.revature.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee insert (Employee employee);


    Employee getById(int id);

    List<Employee> getAllUsers();

    Employee update(Employee employee);



    // Employee getById(int id);
}

