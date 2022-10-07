package services.departmentservice;

import entities.staff.Department;
import entities.staff.Person;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface JaxbDepartmentParser {
    void unmarshaling(List<Department> departments) throws JAXBException;
}
