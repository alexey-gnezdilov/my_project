package services.departmentservice.impl;

import dto.Departments;
import entities.staff.Department;
import services.departmentservice.JaxbDepartmentParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JaxbDepartmentParserImpl implements JaxbDepartmentParser {
    @Override
    public void unmarshaling(List<Department> departments) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Departments.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Departments depFromXml = (Departments) jaxbUnmarshaller.unmarshal(new File("departments"));
        departments.addAll(depFromXml.getDepartments());
    }
}
