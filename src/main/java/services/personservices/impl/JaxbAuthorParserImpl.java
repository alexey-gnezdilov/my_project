package services.personservices.impl;

import dto.Persons;
import entities.staff.Person;
import services.personservices.JaxbAuthorParser;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JaxbAuthorParserImpl implements JaxbAuthorParser {
    public void unmarshaling(List<Person> persons) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Persons personsFromXml = (Persons) jaxbUnmarshaller.unmarshal(new File("persons"));
        persons.addAll(personsFromXml.getPersons());
    }
}
