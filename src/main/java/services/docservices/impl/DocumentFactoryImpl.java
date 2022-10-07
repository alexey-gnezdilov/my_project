package services.docservices.impl;

import entities.documents.Document;
import entities.documents.Incoming;
import entities.documents.Outgoing;
import entities.documents.Task;
import services.docservices.DocumentFactory;
import manager.Manager;
import org.apache.commons.lang3.RandomUtils;
import java.time.LocalDate;
import java.util.UUID;

public class DocumentFactoryImpl implements DocumentFactory {

    @Override
    public <T extends Document> T generateDocument(Class T) {
        if (T.getSimpleName().equals("Task")) {
            return (T) createTask();
        } else if (T.getSimpleName().equals("Incoming")) {
            return (T) createIncoming();
        } else if (T.getSimpleName().equals("Outgoing")) {
            return (T) createOutgoing();
        }
        return null;
    }

    @Override
    public Task createTask() {
        UUID id = UUID.randomUUID();
        String type = "Task";
        String text = "Пока просто текст";
        Integer regNum = RandomUtils.nextInt(0, 5000);
        LocalDate regDate = LocalDate.now();
        String author = Manager.PERSONS_REPO.getPersons().get(RandomUtils.nextInt(0, 11));
        String issueDate = LocalDate.ofEpochDay(RandomUtils.nextInt(0, 326)).toString();
        String executionTerm = String.valueOf(RandomUtils.nextInt(0, 30));
        String respExecutor = Manager.PERSONS_REPO.getPersons().get(RandomUtils.nextInt(0, 11));
        String controlSign = String.valueOf(RandomUtils.nextInt() % 2 == 0);
        String controller = Manager.PERSONS_REPO.getPersons().get(RandomUtils.nextInt(0, 11));
        return new Task(id, type, text, regNum, regDate, author, issueDate, executionTerm, respExecutor,controlSign, controller);
    }

    @Override
    public Incoming createIncoming() {
        UUID id = UUID.randomUUID();
        String type = "Incoming";
        String text = "Пока просто текст";
        Integer regNum = RandomUtils.nextInt(0, 5000);
        LocalDate regDate = LocalDate.ofEpochDay(RandomUtils.nextInt(0, 326));
        String author = Manager.PERSONS_REPO.getPersons().get(RandomUtils.nextInt(0, 11));
        String sender = Manager.PERSONS_REPO.getPersons().get(RandomUtils.nextInt(0, 11));
        String recipientDepartment = Manager.DEPARTMENTS_REPO.getDepartments().get(RandomUtils.nextInt(0, 4));
        return new Incoming(id, type, text, regNum, regDate, author, sender, recipientDepartment, regNum, regDate);
    }

    @Override
    public Outgoing createOutgoing() {
        UUID id = UUID.randomUUID();
        String type = "Outgoing";
        String text = "Пока просто текст";
        Integer regNum = RandomUtils.nextInt(0, 5000);
        LocalDate regDate = LocalDate.ofEpochDay(RandomUtils.nextInt(0, 326));
        String author = Manager.PERSONS_REPO.getPersons().get(RandomUtils.nextInt(0, 11));
        String recipientOrganization = Manager.ORGANIZATIONS_REPO.getOrganizations().get(RandomUtils.nextInt(0, 4));
        String deliveryMethod = RandomUtils.nextInt() % 2 == 0 ? "byEmail" : "byPost";
        return new Outgoing(id, type, text, regNum, regDate, author, recipientOrganization, deliveryMethod);
    }
}
