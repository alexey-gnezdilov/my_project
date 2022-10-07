package dto;

import entities.staff.Department;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "departments")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Departments {
    @XmlElement(name = "department")
    private List<Department> departments = null;
}
