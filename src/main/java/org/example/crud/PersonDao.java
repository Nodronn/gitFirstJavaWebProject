package org.example.crud;

import java.sql.*;
import java.util.ArrayList;

public class PersonDao {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/shop";
    static final String USER = "postgres";
    static final String PASS = "H4R0d7Bn3";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Подключение прошло успешно");

        } catch (Exception e2) {
            System.out.println(e2);
        }
        return connection;
    }

    public static int save(Person person) {
        int status = 0;
        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into crud_example (userName,userPass,userEmail,userCountry) values(?,?,?,?)");
            preparedStatement.setString(1, person.getUserName());
            preparedStatement.setString(2, person.getUserPass());
            preparedStatement.setString(3, person.getUserEmail());
            preparedStatement.setString(4, person.getUserCountry());
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;

    }

    public static ArrayList<Person> getAllPersons() {
        ArrayList<Person> arrayList = new ArrayList<>();

        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from crud_example");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt(1));
                person.setUserName(resultSet.getString(2));
                person.setUserPass(resultSet.getString(3));
                person.setUserEmail(resultSet.getString(4));
                person.setUserCountry(resultSet.getString(5));
                arrayList.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return arrayList;
    }

    public static Person getOnePerson (int id) {
        Person person = new Person();
        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from crud_example where id =?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                person.setId(resultSet.getInt(1));
                person.setUserName(resultSet.getString(2));
                person.setUserPass(resultSet.getString(3));
                person.setUserEmail(resultSet.getString(4));
                person.setUserCountry(resultSet.getString(5));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return person;
    }

    public static int delete(int id) {
        int status = 0;

        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from crud_example where id =?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return status;
    }

    public static int updateUserInfo (Person person) {
        int status = 0;

        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update crud_example " +
                    "set username = ?, userpass = ?, useremail = ?, usercountry = ? " +
                    "where id = ?");
            preparedStatement.setString(1, person.getUserName());
            preparedStatement.setString(2, person.getUserPass());
            preparedStatement.setString(3, person.getUserEmail());
            preparedStatement.setString(4, person.getUserCountry());
            preparedStatement.setInt(5, person.getId());
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return status;
    }
}
