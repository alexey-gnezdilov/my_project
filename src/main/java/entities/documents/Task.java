package entities.documents;

import java.time.LocalDate;
import java.util.UUID;

public class Task extends Document{

    private String issueDate;
    private String executionTerm;
    private String respExecutor;
    private String controllerSign;
    private String controller;

    public Task(UUID id, String type, String text, Integer regNum, LocalDate regDate, String author, String issueDate, String executionTerm, String respExecutor, String controllerSign, String controller) {
        super(id, type, text, regNum, regDate, author);
        this.issueDate = issueDate;
        this.executionTerm = executionTerm;
        this.respExecutor = respExecutor;
        this.controllerSign = controllerSign;
        this.controller = controller;
    }

    @Override
    public String toString() {
        return String.format("%s       № %s at %s %s",
                getType(),
                getRegNum(),
                getRegDate(),
                getText());
    }
}
