package dto;

import entities.staff.Organization;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "organizations")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Organizations {
    @XmlElement(name = "organization")
    private List<Organization> organizations = null;
}