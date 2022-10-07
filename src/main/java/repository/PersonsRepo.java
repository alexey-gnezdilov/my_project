package repository;

import java.util.ArrayList;

public interface PersonsRepo {
    ArrayList<String> getPersons();
    String getAuthor(String author);
}
