package domain.db;

import domain.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDbInMemory {
    private PersonService db = new PersonService();

    public PersonDbInMemory()
    {

    }

    public Person get(String userId)
    {
        return db.get(userId);
    }

    public List<Person> getAll(){
        return db.getAll();
    }

    public void add(Person person){
        db.add(person);
    }

    public void update(Person person){
        db.update(person);
    }

    public void delete(String personId){
        db.delete(personId);
    }
}
