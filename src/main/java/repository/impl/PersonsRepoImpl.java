package repository.impl;

import databasesInMemory.PersonsDatabase;
import repository.PersonsRepo;

import java.util.ArrayList;

public class PersonsRepoImpl implements PersonsRepo {
    private final PersonsDatabase personsDatabase;

    public PersonsRepoImpl() {
        personsDatabase = new PersonsDatabase();
    }

    @Override
    public ArrayList<String> getPersons() {
        return personsDatabase.getPersons();
    }

    @Override
    public String getAuthor(String author) {
        return getPersons()
                .stream()
                .filter(person -> person.equals(author))
                .findAny()
                .orElse(null);
    }
}