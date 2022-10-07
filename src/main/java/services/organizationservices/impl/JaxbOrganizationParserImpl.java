package services.organizationservices.impl;

import dto.Organizations;
import entities.staff.Organization;
import services.organizationservices.JaxbOrganizationParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JaxbOrganizationParserImpl implements JaxbOrganizationParser {
    @Override
    public void unmarshaling(List<Organization> organizations) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Organizations.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Organizations orgsFromXml = (Organizations) jaxbUnmarshaller.unmarshal(new File("organizations"));
        organizations.addAll(orgsFromXml.getOrganizations());
    }
}
