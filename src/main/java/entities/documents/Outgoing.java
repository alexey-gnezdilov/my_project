package entities.documents;

import java.time.LocalDate;
import java.util.UUID;

public class Outgoing extends Document{

    private String recipientOrganization;
    private String deliveryMethod;

    public Outgoing(UUID id, String type, String text, Integer regNum, LocalDate regDate, String author, String recipientOrganization, String deliveryMethod) {
        super(id, type, text, regNum, regDate, author);
        this.recipientOrganization = recipientOrganization;
        this.deliveryMethod = deliveryMethod;
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
