package databasesInMemory;

import entities.staff.Organization;
import manager.Manager;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class OrganizationsDatabase {
    private static ArrayList<Organization> organizations;

    static {
        try {
            organizations = new ArrayList<>();
            Manager.JAXB_ORGANIZATION_PARSER.unmarshaling(organizations);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> getOrganizations() {
        return organizations.stream()
                .map(Organization::getFullName)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
