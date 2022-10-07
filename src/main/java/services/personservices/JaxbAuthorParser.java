package services.personservices;

import entities.staff.Person;
import javax.xml.bind.JAXBException;
import java.util.List;

public interface JaxbAuthorParser {
    void unmarshaling(List<Person> persons) throws JAXBException;
}
