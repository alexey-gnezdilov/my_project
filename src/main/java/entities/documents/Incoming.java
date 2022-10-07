package entities.documents;

import java.time.LocalDate;
import java.util.UUID;

public class Incoming extends Document{

    private String sender;
    private String recipientDepartment;
    private Integer outNumber;
    private LocalDate outRegDate;

    public Incoming(UUID id, String type, String text, Integer regNum, LocalDate regDate, String author, String sender, String recipientDepartment, Integer outNumber, LocalDate outRegDate) {
        super(id, type, text, regNum, regDate, author);
        this.sender = sender;
        this.recipientDepartment = recipientDepartment;
        this.outNumber = outNumber;
        this.outRegDate = outRegDate;
    }

    @Override
    public String toString() {
        return String.format("%s   № %s at %s %s",
                getType(),
                getRegNum(),
                getRegDate(),
                getText());
    }
}
