package databasesInMemory;

import entities.staff.Person;
import manager.Manager;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PersonsDatabase {

    private static ArrayList<Person> persons;

    static {
        try {
            persons = new ArrayList<>();
            Manager.JAXB_AUTHOR_PARSER.unmarshaling(persons);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> getPersons() {
        return persons.stream()
                .map(Person::getFullName)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
