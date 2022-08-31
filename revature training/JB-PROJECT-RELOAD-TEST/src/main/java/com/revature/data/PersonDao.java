package com.revature.data;

import com.revature.entity.Person;

public interface PersonDao {
    public Person insert (Person person);
    public Person getById(int id);
}
