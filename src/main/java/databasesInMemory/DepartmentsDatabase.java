package databasesInMemory;

import entities.staff.Department;
import manager.Manager;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class DepartmentsDatabase {
    private static ArrayList<Department> departments;

    static {
        try {
            departments = new ArrayList<>();
            Manager.JAXB_DEPARTMENT_PARSER.unmarshaling(departments);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> getDepartments() {
        return departments.stream()
                .map(Department::getFullName)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
