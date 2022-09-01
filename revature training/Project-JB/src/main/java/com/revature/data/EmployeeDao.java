package com.revature.data;

import com.revature.entity.Employee;

public interface EmployeeDao {
    Employee insert (Employee employee);


    Employee getById(int id);

    // Employee getById(int id);
}

