package services.docservices;

import entities.documents.Document;
import entities.documents.Incoming;
import entities.documents.Outgoing;
import entities.documents.Task;

public interface DocumentFactory {
    <T extends Document> T generateDocument(Class T);
    Task createTask();
    Incoming createIncoming();
    Outgoing createOutgoing();
}
