package com.revature.data;

import com.revature.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// this class is going to interact with the person table:
public class EmployeeDaoImpl implements EmployeeDao{

    Connection connection;

    public EmployeeDaoImpl() {
        // we're using the same exact connection factory as our pet dao class because
        // it's the same database
        connection = ConnectionFactory.getConnection();
    }





    @Override
    public Employee insert(Employee employee) {
        Logger logger = LoggerFactory.getLogger("Employee Dao Impl");
        String sql = "insert into employee values(default, ?, ?,?, default);";
        try {
            // preparing our statement and indicating that we want the generated id:
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql, 1);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(1, employee.getUserName());

            preparedStatement.setString(2, employee.getPassword());

            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                logger.info("Employee added successfully");
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                resultSet.next();
                int generatedId = resultSet.getInt(1);
                employee.setId(generatedId);
            }else {
                logger.warn("OOPS there was a problem!");
            }

        } catch (SQLException e) {
            logger.warn("Something went wrong with the insert");

        }
        return employee;
    }

    @Override
    public Employee getById(int id) {
        Logger logger = LoggerFactory.getLogger("Employee Dao Impl");
        String sql = "select * from employee where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1 , id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                int idDb = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String title = resultSet.getString("title");
                return new Employee(idDb, name, password, title);
            }
            else {
                logger.warn("Person might not exist");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.warn("SQL Exception occurred");
        }
        return null;
    }

    @Override
    public List<Employee> getAllUsers() {
        List<Employee> employees = new ArrayList<>();

        String sql = "select * from employee;";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String title = resultSet.getString("title");

                Employee employee = new Employee(id, name, password, title);
                employees.add(employee);


            }
        } catch (SQLException e) {
            e.printStackTrace();


        }
        return employees;
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }



}
