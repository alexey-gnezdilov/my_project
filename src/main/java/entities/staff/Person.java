package entities.staff;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
//@XmlRootElement(name = "person")
//@XmlAccessorType(XmlAccessType.FIELD)
public class Person extends Staff{

    private String surname;
    private String name;
    private String patronymic;
    private String workingPosition;
    private String birthDate;
    private String phoneNumber;

    public String getFullName() {
        return surname + " " + name + " " + patronymic;
    }
}