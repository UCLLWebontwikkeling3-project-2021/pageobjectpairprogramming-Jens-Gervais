package domain.db;

import domain.db.util.DbConnectionService;
import domain.model.Contact;
import domain.model.Person;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SqlDataBase {
    private Connection connection;
    private String schema;

    public SqlDataBase() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    public void delete(String userId) {
        if(userId == null) throw new DbException("No one to delete");
        String sql = String.format("DELETE * FROM %s.gebruiker WHERE userid = %s", this.schema, userId);
        try {
            PreparedStatement statementSql = connection.prepareStatement(sql);
            statementSql.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    public Person get(String userId) {
        Person person = null;
        String sql = String.format("SELECT * FROM %s.gebruiker WHERE userid = %s", this.schema, userId);
        try
        {
            PreparedStatement statementSql = connection.prepareStatement(sql);
            ResultSet result = statementSql.executeQuery();
            while (result.next())
            {
                String userid = result.getString("userid");
                String email = result.getString("emailadres");
                String password = result.getString("wachtwoord");
                String firstName = result.getString("voornaam");
                String lastName = result.getString("familienaam");
                person = new Person(userid, email, password, firstName, lastName);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
        return person;
    }

    public void add(Person newPerson) {
        if (newPerson == null) throw new DbException("No one to add");
        String sql = String.format("INSERT INTO %s.gebruiker (userid, emailadres, wachtwoord, voornaam, familienaam) VALUES (?, ?, ?, ?, ?)", this.schema);
        try
        {
            PreparedStatement statementSql = connection.prepareStatement(sql);
            statementSql.setString(1, newPerson.getUserid());
            statementSql.setString(2, newPerson.getEmail());
            statementSql.setString(3, newPerson.getHashedPassword());
            statementSql.setString(4, newPerson.getFirstName());
            statementSql.setString(5, newPerson.getLastName());
            statementSql.execute();
        } catch (SQLException | UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    public List<Person> getAll() {
        List<Person> people = new ArrayList<Person>();
        String sql = String.format("SELECT * FROM %s.gebruiker", this.schema);
        try
        {
            PreparedStatement statementSql = connection.prepareStatement(sql);
            ResultSet result = statementSql.executeQuery();
            while (result.next())
            {
                String userid = result.getString("userid");
                String email = result.getString("emailadres");
                String password = result.getString("wachtwoord");
                String firstName = result.getString("voornaam");
                String lastName = result.getString("familienaam");
                Person person = new Person(userid, email, password, firstName, lastName);
                people.add(person);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
        return people;
    }

    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        String sql = String.format("SELECT * FROM %s.bezoek", this.schema);
        try
        {
            PreparedStatement statementSql = connection.prepareStatement(sql);
            ResultSet result = statementSql.executeQuery();
            while (result.next())
            {
                String userid = result.getString("person_id");
                String email = result.getString("emailadres");
                String telefoonnummer = result.getString("telefoonnummer");
                String firstName = result.getString("voornaam");
                String lastName = result.getString("familienaam");
                Date datum = result.getDate("datum");
                Time aankomstuur = result.getTime("aankomstuur");
                Contact contact = new Contact(userid, email, telefoonnummer, firstName, lastName, datum, aankomstuur);
                contacts.add(contact);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
        return contacts;
    }
}
