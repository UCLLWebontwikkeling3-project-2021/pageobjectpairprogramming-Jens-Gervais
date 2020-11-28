package domain.service;

import domain.db.DbException;
import domain.db.util.DbConnectionService;
import domain.model.Contact;
import domain.model.Person;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
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
        String sql = String.format("DELETE FROM %s.gebruiker WHERE userid = ?", this.schema);
        try {
            PreparedStatement statementSql = connection.prepareStatement(sql);
            statementSql.setString(1, userId);
            statementSql.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    public Person get(String userId) {
        Person person = null;
        String sql = String.format("SELECT * FROM %s.gebruiker WHERE userid = ?", this.schema);
        try
        {
            PreparedStatement statementSql = connection.prepareStatement(sql);
            statementSql.setString(1, userId);
            ResultSet result = statementSql.executeQuery();
            while (result.next())
            {
                String userid = result.getString("userid");
                String email = result.getString("emailadres");
                String password = result.getString("wachtwoord");
                String firstName = result.getString("voornaam");
                String lastName = result.getString("familienaam");
                String rol = result.getString("rol");
                String test = result.getString("positief");
                person = new Person(userid, email, password, firstName, lastName, rol, test);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
        return person;
    }

    public void add(Person newPerson) {
        if (newPerson == null) throw new DbException("No one to add");
        List<Person> people = getAll();
        for (Person person:people) {
            if(person.getUserid().equals(newPerson.getUserid()))
            {
                throw new DbException("User already exists");
            }
        }
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
        List<Person> people = new ArrayList<>();
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
                String rol = result.getString("rol");
                String test = result.getString("positief");
                Person person = new Person(userid, email, password, firstName, lastName, rol, test);
                people.add(person);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
        return people;
    }

    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        int id;
        String sql = String.format("SELECT * FROM %s.bezoek", this.schema);
        try
        {
            PreparedStatement statementSql = connection.prepareStatement(sql);
            ResultSet result = statementSql.executeQuery();
            while (result.next())
            {
                id = result.getInt("id");
                String userid = result.getString("person_id");
                String email = result.getString("emailadres");
                String telefoonnummer = result.getString("telefoonnummer");
                String firstName = result.getString("voornaam");
                String lastName = result.getString("familienaam");
                Timestamp timestamp = result.getTimestamp("date");
                Contact contact = new Contact(id, userid, email, telefoonnummer, firstName, lastName, timestamp);
                contacts.add(contact);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
        return contacts;
    }

    public void addContact(Contact newContact) {
        if (newContact == null) throw new DbException("No one to add");
        String sql = String.format("INSERT INTO %s.bezoek (person_id, voornaam, familienaam, emailadres, telefoonnummer, date) VALUES (?, ?, ?, ?, ?, ?)", this.schema);
        try
        {
            PreparedStatement statementSql = connection.prepareStatement(sql);
            statementSql.setString(1, newContact.getUserid());
            statementSql.setString(2, newContact.getFirstName());
            statementSql.setString(3, newContact.getLastName());
            statementSql.setString(4, newContact.getEmail());
            statementSql.setString(5, newContact.getTelefoonnummer());
            statementSql.setObject(6, newContact.getTimestamp());
            statementSql.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    public void deleteContact(String Id) {
        if(Id == null) throw new DbException("No contact to delete");
        String sql = String.format("DELETE FROM %s.bezoek WHERE id = ?::INTEGER", this.schema);
        try {
            PreparedStatement statementSql = connection.prepareStatement(sql);
            statementSql.setString(1, Id);
            statementSql.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    public void autoDeleteContacts()
    {
        String sql = String.format("DELETE FROM %s.bezoek WHERE date < date_trunc('day', now() - interval '1 month')", this.schema);
        try {
            PreparedStatement statementSql = connection.prepareStatement(sql);
            statementSql.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    public void registerTestResult(String userId, Date date)
    {
        if(userId == null) throw new DbException("No one to register test result for");
        String sql = String.format("UPDATE %s.gebruiker SET positief = 'positief', datumpositief = ? WHERE userid = ?;", this.schema);
        try {
            PreparedStatement statementSql = connection.prepareStatement(sql);
            statementSql.setDate(1, date);
            statementSql.setString(2, userId);
            statementSql.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    public void alterRole(String userid, String value) {
        if(userid == null || value == null) throw new DbException("Invalid values for either userid or value");
        String sql = String.format("UPDATE %s.gebruiker SET rol = ? WHERE userid = ?", this.schema);
        try {
            PreparedStatement statementSql = connection.prepareStatement(sql);
            statementSql.setString(1, value);
            statementSql.setString(2, userid);
            statementSql.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }
}
