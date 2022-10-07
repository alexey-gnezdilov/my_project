package entities.staff;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Department extends Staff{

    private String fullName;
    private String shortName;
    private String director;
    private String contactNumber;

}
