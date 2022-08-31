package com.revature.data;

import com.revature.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

// this class is going to interact with the person table:
public class PersonDaoImpl implements PersonDao{

    Connection connection;

    public PersonDaoImpl() {
        // we're using the same exact connection factory as our pet dao class because
        // it's the same database
        connection = ConnectionFactory.getConnection();
    }





    @Override
    public Person insert(Person person) {
        Logger logger = LoggerFactory.getLogger("Pet Dao Impl");
        String sql = "insert into person values(default, ?, ?);";
        try {
            // preparing our statement and indicating that we want the generated id:
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getPassword());

            int count = preparedStatement.executeUpdate();

            if (count == 1) {
                logger.info("Person added succesfully");
            }
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            person.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            logger.warn("Something went wrong with the insert");
            return null;
        }
        return person;
    }

    @Override
    public Person getById(int id) {
        Logger logger = LoggerFactory.getLogger("Pet Dao Impl");
        String sql = "select * from person where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1 , id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                int idDb = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                return new Person(idDb, name, password);
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
}
