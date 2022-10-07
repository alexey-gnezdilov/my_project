package services.organizationservices;

import entities.staff.Organization;
import javax.xml.bind.JAXBException;
import java.util.List;

public interface JaxbOrganizationParser {
    void unmarshaling(List<Organization> organizations) throws JAXBException;
}
